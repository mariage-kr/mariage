package com.multi.mariage.report.Controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.report.dto.response.ReportResponse;
import com.multi.mariage.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ReportController {
    private final ReportService reportService;


    @PostMapping("/user/review/report/{reviewId}")
    public ResponseEntity<ReportResponse> report(@Authenticated AuthMember authMember,
                                                 @PathVariable Long reviewId) {
        ReportResponse response = reportService.report(authMember, reviewId);
        return ResponseEntity.ok(response);
    }
}
