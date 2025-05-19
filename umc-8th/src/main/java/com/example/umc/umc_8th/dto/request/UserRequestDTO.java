package com.example.umc.umc_8th.dto.request;

import lombok.Getter;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory;
        //내 객체랑 비교
        //근데 예제 객체도 gender 문자로 돼있더거같은데
    }
}
