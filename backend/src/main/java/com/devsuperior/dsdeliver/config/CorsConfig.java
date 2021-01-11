package com.devsuperior.dsdeliver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("https://sds2-max.herokuapp.com", "http://localhost:3000")
		.allowedMethods("GET","POST","PUT","OPTIONS","DELETE","HEAD","TRACE", "CONNECT");
	}
}
