package com.iot.backend.services.authentication.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("Servlet Path captured: "+ request.getServletPath());
        if (request.getServletPath().equals("/login") || request.getServletPath().equals("/api/login") ||
            request.getServletPath().equals("/api/user/save") || request.getServletPath().equals("/api/ring")) {
            filterChain.doFilter(request, response);
        } else {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            log.info("CAPTURED Auth Header: " + authorizationHeader);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                try {
                    String token = authorizationHeader.substring("Bearer ".length());
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));

                    log.info("Verifying User with token: " + token);
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(token);

                    String username = decodedJWT.getSubject();
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority("USER"));

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    log.info("USER Verified");
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    log.error("Error Decoding token during Authorization : " +  e.getMessage());
                    Map<String, String> error = new HashMap<>();
                    error.put("error", "Error Verifying the user: " + e.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    response.setHeader("error", "Error verifying the user: " + e.getMessage());
                    response.setStatus(FORBIDDEN.value());
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }

            } else {
                log.info("Forbidden User Entry");
                response.setStatus(FORBIDDEN.value());
                response.setHeader("message", "FORBIDDEN You don't have access please sign in or register");
                Map<String, String> msg = new HashMap<>();
                msg.put("message", "FORBIDDEN You don't have access please sign in or register");
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), msg);
            }
        }
    }
}
