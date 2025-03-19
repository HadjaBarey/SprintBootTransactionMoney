package com.kadous.gestiondealer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Appliquer à tous les endpoints
                        .allowedOrigins(
                            "*"  // Autoriser toutes les origines pendant le développement
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(false);  // Doit être false si allowedOrigins est "*"
            }
        };
    }
}
// public class CorsConfig {

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/**")  // Appliquer à tous les endpoints
//                         .allowedOrigins("http://localhost:3000")  // Origine Nuxt.js
//                         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes HTTP autorisées
//                         .allowedHeaders("*")  // Tous les en-têtes autorisés
//                         .allowCredentials(true);  // Permettre l'envoi de cookies
//             }
//         };
//     }
// }
