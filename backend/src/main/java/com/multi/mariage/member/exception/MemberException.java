package com.multi.mariage.member.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class MemberException extends MariageException {
    public MemberException(ErrorCode code) {
        super(code);
    }
}
