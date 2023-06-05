package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.security.jwt.IJwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.text.ParseException;

@Service
public class AuthenticationService implements IAuthenticationService{

    private AuthenticationManager authenticationManager;

    private IJwtProvider iJwtProvider;

    public AuthenticationService(AuthenticationManager authenticationManager,IJwtProvider iJwtProvider) {
        this.authenticationManager = authenticationManager;
        this.iJwtProvider= iJwtProvider;
    }

    @Override
    public User signInAndReturnJWT(User sigUnRequest) throws ParseException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sigUnRequest.getUsername(),
                        sigUnRequest.getPassword()
                )
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = iJwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }


}
