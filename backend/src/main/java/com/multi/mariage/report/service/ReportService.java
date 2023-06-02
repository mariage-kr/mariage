package com.multi.mariage.report.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.report.domain.Report;
import com.multi.mariage.report.domain.ReportRepository;
import com.multi.mariage.report.dto.response.ReportResponse;
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

        /* TODO: 2023/06/02 이미 신고한 사람인지 검증 */
        Report report = new Report();
        report.setMember(member);
        report.setReview(review);

        reportRepository.save(report);

        /* TODO: 2023/06/02 신고 개수 가져오기 */
        boolean isReport = review.isReport(10);
        return new ReportResponse(isReport);
    }
}
