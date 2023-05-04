package com.multi.mariage.storage.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum StorageErrorCode implements ErrorCode {
    FILE_UPLOAD_FAILED(500, "STORAGE_01", "파일 업로드를 실패하였습니다."),
    FILE_IS_NOT_EXIST(400, "STORAGE_02", "업로드한 파일이 존재하지 않습니다."),
    FAILED_TO_REMOVE_FILE(500, "STORAGE_03", "파일 삭제를 실패하였습니다.");
    private int statusCode;
    private String errorCode;
    private String message;

    StorageErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
