package com.example.umc.umc_8th.validation.validator;

import com.example.umc.umc_8th.apiPayload.code.status.ErrorStatus;
import com.example.umc.umc_8th.repository.StoreRepository.AcceptedMissionRepository;
import com.example.umc.umc_8th.repository.StoreRepository.MissionRepository;
import com.example.umc.umc_8th.validation.annotation.NotAlreadyAccepted;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionAlreadyAcceptedValidator implements ConstraintValidator<NotAlreadyAccepted, Long> {
    private final AcceptedMissionRepository acceptedMissionRepository;

    @Override
    public void initialize(NotAlreadyAccepted constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isExist = acceptedMissionRepository.existsByMissionId(value);

        if (isExist) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_ACCEPTED.toString()).addConstraintViolation();
        }

        return !isExist;
    }
}

