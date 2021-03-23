package com.petproject.sweater.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")//все обращения по указанному пути
                .addResourceLocations("file:///" + uploadPath + "/");//file:-протокол / будут перенаправляться
        registry.addResourceHandler("/static/**")//все обращения по указанному пути
                //classpath:-протокол / ресурсы будут искаться не где-то в файловой системе а в дереве проекта
                //либо в списке классов или ресурсов
                .addResourceLocations("classpath:/static/");
    }
}