package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;

import java.text.ParseException;

public interface IAuthenticationService {
    User signInAndReturnJWT(User sigUnRequest) throws ParseException;
}
