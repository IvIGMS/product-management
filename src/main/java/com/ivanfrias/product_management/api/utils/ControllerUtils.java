package com.ivanfrias.product_management.api.utils;

import com.ivanfrias.product_management.exceptions.UnauthorizedException;
import com.ivanfrias.product_management.security.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import static com.ivanfrias.product_management.api.utils.ControllerUtilsConstants.STRING_NO_PREMISSIONS;

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

    protected String getRole() {
        return (String) jwtService.extractAllClaims(getToken()).get("role");
    }

    protected void checkIsAdmin() {
        if(!ControllerUtilsConstants.ADMIN_ROLE.equals(getRole())) {
            throw new UnauthorizedException(STRING_NO_PREMISSIONS);
        }
    }

    protected void checkIsManager() {
        if(!ControllerUtilsConstants.MANAGER_ROLE.equals(getRole())) {
            throw new UnauthorizedException(STRING_NO_PREMISSIONS);
        }
    }
}
