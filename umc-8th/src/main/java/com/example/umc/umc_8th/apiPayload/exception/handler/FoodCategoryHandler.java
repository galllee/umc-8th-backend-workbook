package com.example.umc.umc_8th.apiPayload.exception.handler;

import com.example.umc.umc_8th.apiPayload.code.status.BaseErrorCode;
import com.example.umc.umc_8th.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
