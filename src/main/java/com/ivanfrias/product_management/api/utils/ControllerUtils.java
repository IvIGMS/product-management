package com.ivanfrias.product_management.api.utils;

import com.ivanfrias.product_management.security.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ControllerUtils {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected JwtService jwtService;

    protected String getToken() {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        throw new RuntimeException("No se encontró token en la request");
    }

    protected Claims getAllClaims() {
        return jwtService.extractAllClaims(getToken());
    }
}
