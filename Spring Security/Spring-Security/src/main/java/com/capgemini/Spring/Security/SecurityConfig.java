package com.capgemini.Spring.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		return http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth.requestMatchers("/practices").
						permitAll().requestMatchers("/admin").authenticated())
						.httpBasic(Customizer.withDefaults()).build();
	}
	
	@Bean
	//spring security is going to read from this class UserDetailsService
	public UserDetailsService getUserDetails() {
		
		UserDetails admin = User.withUsername("admin")
				.password("{noop}1234") //used to encode the password
				.roles("ADMIN")
				.build();
		
		UserDetails user=User.withUsername("Himani")
		.password("{noop}9876")
		.roles("USER").build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
