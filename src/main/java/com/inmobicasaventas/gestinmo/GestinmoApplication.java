package com.inmobicasaventas.gestinmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GestinmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestinmoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")
					.allowedOriginPatterns("localhost:8000", "localhost:8081", "*", "[A-z]*")
					.allowedMethods("POST", "GET", "PUT", "DELETE")
					.allowedHeaders("*").allowCredentials(false);
			}
		};
	}
}
