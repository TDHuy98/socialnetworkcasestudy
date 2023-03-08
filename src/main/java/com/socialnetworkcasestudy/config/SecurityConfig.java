package com.socialnetworkcasestudy.config;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig extends SecurityAutoConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //cấu hình các HTTP request được ủy quyền (auhthorized HTTP requests): bất kì request nào phải được xác thực,
        http.authorizeHttpRequests(auth -> {
            auth.anyRequest().authenticated();
        });
        //không muốn có session nữa
        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        //tắt CSRF protection
        http.csrf().disable();

//        http.formLogin();
//        http.httpBasic();
        return http.build();
    }
}
