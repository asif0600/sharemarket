package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.user.filter.JWTFilter;

@SpringBootApplication
public class UserApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new JWTFilter());
		fb.addUrlPatterns("/api/user/*");
		return fb;

	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
