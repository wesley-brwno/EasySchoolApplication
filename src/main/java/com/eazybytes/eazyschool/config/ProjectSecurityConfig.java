package com.eazybytes.eazyschool.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                .requestMatchers("/displayMessages").hasRole("ADMIN")
                .requestMatchers("/closeMsg/**").hasRole("ADMIN")
                //.requestMatchers("/courses").authenticated()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/logout").permitAll()
                .requestMatchers("public/**").permitAll()
                .requestMatchers("/dashboard").authenticated()
                .anyRequest().authenticated());
        http.csrf().ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers("*/public/**");
        http.formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll();
        http.httpBasic(withDefaults());

        return http.build();
    }
}
