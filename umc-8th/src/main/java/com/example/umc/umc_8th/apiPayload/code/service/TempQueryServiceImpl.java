package com.example.umc.umc_8th.apiPayload.code.service;

import com.example.umc.umc_8th.apiPayload.code.status.ErrorStatus;
import com.example.umc.umc_8th.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPPTION);
    }
}
