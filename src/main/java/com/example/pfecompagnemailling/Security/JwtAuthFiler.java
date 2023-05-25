package com.example.pfecompagnemailling.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.pfecompagnemailling.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFiler  extends OncePerRequestFilter  {
    private final JwtUtil jwtUtil ;  
    private final UserRepository userRepository ;     

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                final String authHeader = request.getHeader("Authorization");
                String userName = null;
                String jwt = null;

                if(StringUtils.hasLength(authHeader) && authHeader.startsWith("Bearer "))
                {
                    jwt = authHeader.substring(7);
                    userName = jwtUtil.extractUsername(jwt);
                 
                }else {
                    logger.warn("JWT Token does not begin with Bearer String");
                }

                if(StringUtils.hasLength(userName) && SecurityContextHolder.getContext().getAuthentication() == null)
                {
                    UserDetails userDetails = userRepository.findByLogin(userName).orElse(null);
                    if(jwtUtil.validateToken(jwt,userDetails))
                    {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails , null , userDetails.getAuthorities()
                    );

                    usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                    );

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    
                    }
       
                }
                filterChain.doFilter(request , response);

    }
    
}
