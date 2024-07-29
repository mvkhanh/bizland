package com.javaweb.config;


import com.javaweb.enums.Role;
import com.javaweb.security.CustomSuccessHandler;
import com.javaweb.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final CustomUserDetailsService userDetailsService;

    private final CustomSuccessHandler customSuccessHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(registry -> {
                registry.requestMatchers("/register", "/static/**", "/WEB-INF/views/login.jsp").permitAll();
                registry.requestMatchers(HttpMethod.GET, "/admin/buildings", "/admin/buildings-edit-{id}", "/admin/home", "/admin/customers", "/admin/customers-edit-{id}").hasAnyRole(Role.STAFF.name(), Role.ADMIN.name());
                registry.requestMatchers(HttpMethod.POST, "/admin/buildings", "/admin/customers", "/admin/transactions").hasAnyRole(Role.STAFF.name(), Role.ADMIN.name());
                registry.requestMatchers("/admin/**").hasRole(Role.ADMIN.name());
                registry.anyRequest().authenticated();
            })
            .formLogin(httpSecurityFormLoginConfigurer -> {
                httpSecurityFormLoginConfigurer.loginPage("/login")
                        .successHandler(customSuccessHandler)
                        .permitAll();
            })
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            )
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return userDetailsService;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
