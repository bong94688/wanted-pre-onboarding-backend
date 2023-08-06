package com.example.wantedpreonboardingbackend.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {


    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";



    @Override
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                //허용된 요청방식
                .allowedMethods(ALLOWED_METHOD_NAMES.split(","))
                .allowedMethods("GET","POST","PUT","DELETE")
                //허용될 요청 헤더
                .allowedHeaders("*")
                //인증에 관한 정보 허용
                .allowCredentials(true)
                //타임아웃 시간 설정
                .maxAge(3600);
    }
}