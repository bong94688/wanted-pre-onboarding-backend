<<<<<<< HEAD
package com.example.wantedpreonboardingbackend.configuration;
=======
package com.example.bitcamptiger.configuration;
>>>>>>> 365d2d9dcc418522926789802695e8665737de00

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

<<<<<<< HEAD

    public static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH";

=======
>>>>>>> 365d2d9dcc418522926789802695e8665737de00
//    @Value(value = "${file.path}")
//    private String filePath;
//
//
//    @Override
//    public void  addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
//
//
////       하위풀더에 업로드 요청이오면 filePath에서 꺼내서 쓸수 있게 설정
//        resourceHandlerRegistry.addResourceHandler("/upload/**")
//                .addResourceLocations(filePath);
//
//
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                //허용된 요청방식
<<<<<<< HEAD
                .allowedMethods(ALLOWED_METHOD_NAMES.split(","))
=======
                .allowedMethods("GET","POST","PUT","DELETE")
>>>>>>> 365d2d9dcc418522926789802695e8665737de00
                //허용될 요청 헤더
                .allowedHeaders("*")
                //인증에 관한 정보 허용
                .allowCredentials(true)
                //타임아웃 시간 설정
                .maxAge(3600);
    }
<<<<<<< HEAD
=======

>>>>>>> 365d2d9dcc418522926789802695e8665737de00
}