package com.app.authservice.security;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 
@Configuration
public class SecurityConfig {
 
        private final JwtFilter jwtFilter;
 
        public SecurityConfig(JwtFilter jwtFilter) {
                this.jwtFilter = jwtFilter;
        }
 
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
 
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 
                http
                                // ❌ Disable CSRF (important for APIs)
                                .csrf(csrf -> csrf.disable())
 
 
                                // 🔐 Authorization rules
                                .authorizeHttpRequests(auth -> auth
                                                // Allow preflight requests
                                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
 
                                                // Public endpoints
                                                .requestMatchers(
                                                                "/auth/**",
                                                                "/h2-console/**",
                                                                "/actuator/**")
                                                .permitAll()
 
                                                // All others need authentication
                                                .anyRequest().authenticated())
 
                                // Fix for H2 console (optional)
                                .headers(headers -> headers
                                                .frameOptions(frame -> frame.sameOrigin()))
 
                                // 🔑 Add JWT filter
                                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 
                return http.build();
        }
}