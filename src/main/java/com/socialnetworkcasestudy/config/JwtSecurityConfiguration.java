//package com.socialnetworkcasestudy.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class JwtSecurityConfiguration {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .httpBasic()
//                .and().sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//
//        ;
//        return http.build();
//    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var user=User.withUsername("user")
//                .password("{noop}test")
//                .roles("USER")
//                .build();
//        var admin=User.withUsername("admin")
//                .password("{noop}test")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager();
//    }
//}
