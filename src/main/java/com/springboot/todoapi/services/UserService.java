package com.springboot.todoapi.services;

import com.springboot.todoapi.error.NotFoundException;
import com.springboot.todoapi.models.AppUser;
import com.springboot.todoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails  loadUserByUsername(String username) throws UsernameNotFoundException {
        //return new User("medmed", passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
        AppUser user = userRepository.findByEmail(username);
        if (user == null) {
            throw new NotFoundException("User Not found");
        }
        return user;
    }

    public void save(AppUser appUser) {
        appUser.setPassword(passwordEncoder().encode(appUser.getPassword()));
        this.userRepository.save(appUser);
    }

    public List<AppUser> findAll(){
        return userRepository.findAll();
    }

}
