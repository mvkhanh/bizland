package com.javaweb.security;

import com.javaweb.enums.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(response.isCommitted()) System.out.println("Can't redirect");
        else{
            request.getSession().setAttribute("user", authentication.getPrincipal());
            redirectStrategy.sendRedirect(request, response, determineTargetUrl(authentication));
        }
    }

    private String determineTargetUrl(Authentication authentication){
        if(authentication.getAuthorities().stream().anyMatch(i -> i.getAuthority().equals("ROLE_" + Role.USER.name()))) return "/";
        return "/admin/home";
    }
}
