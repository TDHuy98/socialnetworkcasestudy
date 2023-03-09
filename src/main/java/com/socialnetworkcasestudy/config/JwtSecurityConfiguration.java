//package com.socialnetworkcasestudy.config;
//
//import com.nimbusds.jose.JOSEException;
//import com.nimbusds.jose.jwk.JWKSet;
//import com.nimbusds.jose.jwk.RSAKey;
//import com.nimbusds.jose.jwk.source.JWKSource;
//import com.nimbusds.jose.proc.SecurityContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.interfaces.RSAPublicKey;
//import java.util.UUID;
//
//@Configuration
//public class JwtSecurityConfiguration {
//    @Autowired
//    private EncoderConfiguration encoderConfiguration;
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        //cấu hình các HTTP request được ủy quyền (auhthorized HTTP requests): bất kì request nào phải được xác thực,
//        http.authorizeHttpRequests(auth -> {
//            auth.anyRequest().authenticated();
//        });
//        //không muốn có session nữa
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        //tắt CSRF protection
//        http.csrf().disable();
//        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//        http.httpBasic();
//        http.headers().frameOptions().sameOrigin();
//        return http.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        var admin = User.withUsername("admin").password("admin").passwordEncoder(str -> encoderConfiguration.passwordEncoder().encode(str)).build();
////        return null;
////    }
//
//    @Bean
//    public KeyPair keyPair() {
//        try {
//
//            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            keyPairGenerator.initialize(2048);
//            return keyPairGenerator.generateKeyPair();
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    @Bean
//    public RSAKey rsaKey(KeyPair keypair) {
//        return new RSAKey.Builder((RSAPublicKey) keypair.getPublic()).privateKey(keypair.getPrivate()).keyID(UUID.randomUUID().toString()).build();
//    }
//
//    @Bean
//    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
//        var jwkSet = new JWKSet(rsaKey);
//        return (jwkSelector, context) -> jwkSelector.select(jwkSet);
//
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
//        return NimbusJwtDecoder
//                .withPublicKey(rsaKey.toRSAPublicKey())
//                .build();
//    }
////Global configurer cors
////    @Bean
////    public WebMvcConfigurer corsConfigure() {
////        return new WebMvcConfigurer() {
////            public void addCorsMapping(CorsRegistry registry) {
////                registry.addMapping("/**")
////                        .allowedMethods("*")
////                        .allowedOrigins("*");
////            }
////        };
////    }
//
////
//
//
//}
//
