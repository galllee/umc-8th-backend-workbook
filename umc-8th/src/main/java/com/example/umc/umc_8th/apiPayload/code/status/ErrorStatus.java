package com.example.umc.umc_8th.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode{

    // for test
    TEMP_EXCEPPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트입니다."),
    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수입니다."),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST,"FOODCATEGORY4001", "음식 카테고리가 없습니다."),
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001", "지역이 존재하지 않습니다."),
    MISSION_ALREADY_ACCEPTED(HttpStatus.BAD_REQUEST, "ACCEPTEDMISSION4001", "미션이 이미 진행중입니다."),
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "가게가 존재하지 않습니다."),

    PAGE_INVALID(HttpStatus.BAD_REQUEST, "PAGE4001", "페이지는 1 이상의 숫자여야 합니다."),
    // 예시
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }


}
