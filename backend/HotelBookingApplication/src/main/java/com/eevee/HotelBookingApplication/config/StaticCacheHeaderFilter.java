package com.eevee.HotelBookingApplication.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class StaticCacheHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        if ("/robots.txt".equals(path) || "/sitemap.xml".equals(path)) {
            res.setHeader("Cache-Control", null);  // Remove old
            res.setHeader("Pragma", null);         // Remove old
            res.setHeader("Expires", null);        // Remove old
        
            res.setHeader("Cache-Control", "public, max-age=3600");
            res.setHeader("Expires", "3600");
        }
        chain.doFilter(request, response);
    }
}
