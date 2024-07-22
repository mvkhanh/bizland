//package com.javaweb.config;
//
//import com.javaweb.security.CustomSuccessHandler;
//import com.javaweb.enums.Role;
////import com.javaweb.filter.JwtAuthenticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
////    private final JwtAuthenticationFilter filter;
//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler(){
//        return new CustomSuccessHandler();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin(formLogin -> formLogin.loginPage("/login")
//                        .usernameParameter("username")
//                        .passwordParameter("password")
//                        .permitAll()
//                        .loginProcessingUrl("/login-check")
//                        .successHandler(authenticationSuccessHandler())
//                )
//                .authorizeHttpRequests(requests -> {
//                    requests
//                            .requestMatchers("/trang-chu", "/login", "/static/**", "**").permitAll()
//                            .requestMatchers("/admin/buildings-edit", "/admin/buildings/assignment", "/admin/buildings-edit-{id}").hasAnyRole(Role.ADMIN.name())
//                            .requestMatchers("/admin/**").hasAnyRole(Role.ADMIN.name(), Role.STAFF.name())
//                            //Cần phải cụ thể các phương thức như GET POST đối với từng api, user-edit chỉ cho phép admin chứ ko staff
//                            .anyRequest().authenticated();
//                });
////                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//}
