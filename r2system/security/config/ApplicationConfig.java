package com.project.r2system.security.config;

import com.project.r2system.api.commons.ArticleMapping;
import com.project.r2system.api.commons.CategoryMapping;
import com.project.r2system.api.commons.WorkpowerMapping;
import com.project.r2system.security.jwt.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    @Bean
    public JwtUtils jwtUtils(){return new JwtUtils();}
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public ArticleMapping articleMapping(){
        return new ArticleMapping();
    }
    @Bean
    public CategoryMapping categoryMapping(){
        return new CategoryMapping();
    }
    @Bean
    public WorkpowerMapping workpowerMapping(){
        return new WorkpowerMapping();
    }
}
