package com.javaweb.config;

import com.javaweb.enums.Role;
import com.javaweb.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
//@EnableWebMvc
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers("/login", "/register").permitAll() //và các api không cần đăng nhập khác
                            .requestMatchers("/admin/**").hasAnyRole(Role.MANAGER.name())
                            //Cần phải cụ thể các phương thức như GET POST đối với từng api, user-edit chỉ cho phép admin chứ ko staff
                            .anyRequest().authenticated();
                });
        return http.build();
    }
}
