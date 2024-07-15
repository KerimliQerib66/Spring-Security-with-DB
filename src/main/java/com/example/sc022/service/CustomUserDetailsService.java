package com.example.sc022.service;

import com.example.sc022.entities.UserEntity;
import com.example.sc022.repository.UserRepository;
import com.example.sc022.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> u = userRepository.findByUsername(username);
            return u.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("UserName Not Found"+username));
    }
}
