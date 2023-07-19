
package com.example.propertymanagement.CORS;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*")
                .allowedOrigins("*") // Replace with the origin of your frontend
                .allowedMethods("POST","GET","PUT")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}