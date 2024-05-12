package com.gfg.library69.service;

import com.gfg.library69.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    public void addUser(User user);
}
