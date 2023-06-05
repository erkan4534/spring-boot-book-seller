package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;
import javax.transaction.Transactional;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    @Transactional
    void makeAdmin(String username);

    Optional<User> findByUsername(String username);
}
