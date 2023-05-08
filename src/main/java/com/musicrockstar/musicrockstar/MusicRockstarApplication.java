package com.musicrockstar.musicrockstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class MusicRockstarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicRockstarApplication.class, args);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers("/login").permitAll();
	}


	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for images
		registry.addResourceHandler("/images/**").addResourceLocations("/static/images/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}


}

