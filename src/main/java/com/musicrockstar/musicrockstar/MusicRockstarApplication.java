package com.musicrockstar.musicrockstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class MusicRockstarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicRockstarApplication.class, args);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers("/login").permitAll();
	}

}

