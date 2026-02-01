package com.axel.taskmanager.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; // <--- Importante
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service; // <--- Importante
import org.springframework.transaction.annotation.Transactional;

import com.axel.taskmanager.models.User;
import com.axel.taskmanager.repository.UserRepository;

@Service // ESTO ES OBLIGATORIO
public class UserDetailsServiceImpl implements UserDetailsService { // ESTO TAMBIEN

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}