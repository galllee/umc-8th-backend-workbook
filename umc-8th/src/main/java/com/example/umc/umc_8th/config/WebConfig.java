package com.example.umc.umc_8th.config;

import com.example.umc.umc_8th.validation.annotation.PageResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final PageResolver pageResolver;

    public WebConfig(PageResolver pageResolver) {
        this.pageResolver = pageResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(pageResolver);
    }
}
