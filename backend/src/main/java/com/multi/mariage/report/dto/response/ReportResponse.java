package com.multi.mariage.report.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReportResponse {
    private boolean isReport;

    public ReportResponse(boolean isReport) {
        this.isReport = isReport;
    }
}
