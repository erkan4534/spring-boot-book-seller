package com.sha.springbootbookseller.security.jwt;

import com.sha.springbootbookseller.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface IJwtProvider {

    String generateToken(UserPrincipal auth) throws ParseException;

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}

