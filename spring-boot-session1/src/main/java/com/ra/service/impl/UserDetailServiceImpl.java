package com.ra.service.impl;

import com.ra.model.UserDetailsAdapter;
import com.ra.model.entity.UserEntity;
import com.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            UserDetails userDetails = new UserDetailsAdapter(user);
            return userDetails;
        }
        throw new UsernameNotFoundException("User name \"" + username + "\" not found!");
    }
}
