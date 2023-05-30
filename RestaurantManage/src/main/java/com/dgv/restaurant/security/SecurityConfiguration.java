//package com.dgv.restaurant.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//
//	@Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests().antMatchers("/user/login").permitAll()
//		.antMatchers("/inventory/**").hasAuthority("Admin")
//		.anyRequest().authenticated().and().formLogin()
//		.loginPage("/login").permitAll()
//		.and()
//		.rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
//		.and()
//		.logout().permitAll();
//		 http.headers().frameOptions().sameOrigin();
//		return http.build();
//	}
//}
