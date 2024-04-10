package com.srinivas.springsecurity.service;

import com.srinivas.springsecurity.model.User;
import com.srinivas.springsecurity.model.UserPrincipal;
import com.srinivas.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);

        if(user==null){
            System.out.println("404 : User not found");
            throw new UsernameNotFoundException("404 : User not found");
        }
        return new UserPrincipal(user);
    }
}
