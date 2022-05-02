package com.iot.backend.services.medicinedispatcher.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Configuration
@Slf4j
public class CustomRequestFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String originHeader = request.getHeader("x-origin");
        log.info(originHeader);
        /*if (originHeader != null && originHeader.contains("Master")) {
            filterChain.doFilter(request, response);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Direct Access not allowed");
            error.put("message", "Forbidden Access");
            response.setStatus(HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value());
            response.setHeader("error", "Direct Access not allowed Resource Forbidden");
            new ObjectMapper().writeValue(response.getOutputStream(), error);
        }*/

        filterChain.doFilter(request, response);
    }
}
