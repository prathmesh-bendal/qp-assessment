package com.pbendal.gms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails user1=User.withUsername("user1")
				.password(passwordEncoder().encode("pass1"))
				.roles("NORMAL")
				.build();
		
		UserDetails user2=User.withUsername("user2")
				.password(passwordEncoder().encode("pass2"))
				.roles("NORMAL")
				.build();
		
		UserDetails user3=User.withUsername("user3")
				.password(passwordEncoder().encode("pass3"))
				.roles("NORMAL")
				.build();
		
		UserDetails admin1=User.withUsername("admin1")
				.password(passwordEncoder().encode("root1"))
				.roles("ADMIN")
				.build();
		UserDetails admin2=User.withUsername("admin2")
				.password(passwordEncoder().encode("root2"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2,user3,admin1,admin2);
		
		
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
		http.csrf().disable()
		.httpBasic()
		.and()
		.authorizeRequests()
		.requestMatchers("/v1/product/list/**")
		.hasAnyRole("ADMIN","NORMAL")
		.requestMatchers("/v1/product/**")
		.hasRole("ADMIN")
		.requestMatchers("/v1/order")
		.hasAnyRole("ADMIN","NORMAL")
		.anyRequest()
		.permitAll()
		.and();
		
		
		return http.build();
		
	}
	
	

}
