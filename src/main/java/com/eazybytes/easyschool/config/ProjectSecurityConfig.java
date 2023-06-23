package com.eazybytes.easyschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        // Permit all reqeusts inside the Web Application
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());

        //Deny all Request inside the Web Application
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("", "/", "/home").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/courses").permitAll()
                //.requestMatchers("/courses").authenticated()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .anyRequest().authenticated());
        http.csrf().disable();
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());

        return http.build();
    }
}
