package com.example.umc.umc_8th.apiPayload.exception;

import com.example.umc.umc_8th.apiPayload.code.status.BaseErrorCode;
import com.example.umc.umc_8th.apiPayload.code.status.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
