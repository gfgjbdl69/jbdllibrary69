package com.gfg.library69.service.impl;

import com.gfg.library69.domain.User;
import com.gfg.library69.exception.UserAlreadyExistsException;
import com.gfg.library69.repository.UserRepository;
import com.gfg.library69.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserService {

    /**
     * Create the userRepository
     * Autowire here
     * fetch user data from the repository.
     * */

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw  new UsernameNotFoundException("User not found");
        }

        //return optionalUser.orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public void addUser(User user) {
        Optional<User> optionalUser=userRepository.findByUsername(user.getUsername());
        if(optionalUser.isEmpty()){
            user.setAuthority("USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }else {
            throw new UserAlreadyExistsException("User already exists");
        }

    }
}
