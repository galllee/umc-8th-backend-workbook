package com.example.umc.umc_8th.validation.annotation;

import com.example.umc.umc_8th.apiPayload.code.status.ErrorStatus;
import com.example.umc.umc_8th.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class PageResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        String raw = webRequest.getParameter("page");

        int page = 1;
        try {
            page = Integer.parseInt(raw);
        } catch (Exception e) {
            throw new NumberFormatException();
        }

        if (page < 1) {
            throw new GeneralException(ErrorStatus.PAGE_INVALID);
        }

        return page - 1;
    }
}
