package com.multi.mariage.report.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.report.domain.Report;
import com.multi.mariage.report.domain.ReportRepository;
import com.multi.mariage.report.dto.response.ReportResponse;
import com.multi.mariage.report.exception.ReportErrorCode;
import com.multi.mariage.report.exception.ReportException;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.service.ReviewFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final MemberFindService memberFindService;
    private final ReviewFindService reviewFindService;

    @Transactional
    public ReportResponse report(AuthMember authMember, Long reviewId) {
        Member member = memberFindService.findById(authMember.getId());
        Review review = reviewFindService.findById(reviewId);
        
        validateIsAlreadyReport(member, review);

        Report report = Report.from(member, review);
        reportRepository.save(report);

        /* TODO: 2023/06/02 신고 개수 가져오기 */
        boolean isReport = review.isReport(10);
        return new ReportResponse(isReport);
    }

    private void validateIsAlreadyReport(Member member, Review review) {
        if (reportRepository.existsByMemberAndReview(member, review)) {
            throw new ReportException(ReportErrorCode.IS_ALREADY_REPORT);
        }
    }
}
