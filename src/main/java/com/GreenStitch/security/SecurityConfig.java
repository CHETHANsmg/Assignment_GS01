package com.GreenStitch.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.GreenStitch.jwt.JwtGeneratorFilter;
import com.GreenStitch.jwt.JwtValidationFilter;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain mySecurity(HttpSecurity http) throws Exception {
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(csrf -> csrf.disable())
				.authorizeRequests(authorize -> authorize.requestMatchers("/mysql").permitAll()
						.requestMatchers("/app/**").permitAll().requestMatchers(HttpMethod.GET, "/logged-in/**")
						.hasAnyRole("USER").anyRequest().authenticated())
				.addFilterAfter(new JwtGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JwtValidationFilter(), BasicAuthenticationFilter.class)
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
