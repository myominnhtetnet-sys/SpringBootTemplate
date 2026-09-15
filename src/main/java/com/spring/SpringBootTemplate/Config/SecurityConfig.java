package com.spring.SpringBootTemplate.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean // return must be obj
	SecurityFilterChain filerChain(HttpSecurity http) {
		http.authorizeHttpRequests(auth-> auth.anyRequest().authenticated()).formLogin(Customizer.withDefaults());
		 return http.build();
	}

}
