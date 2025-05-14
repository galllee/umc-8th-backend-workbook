package com.example.umc.umc_8th.apiPayload.code;

import com.example.umc.umc_8th.apiPayload.code.status.ReasonDTO;

public interface BaseCode {

    ReasonDTO getReason();

    ReasonDTO getReasonHttpStatus();
}
