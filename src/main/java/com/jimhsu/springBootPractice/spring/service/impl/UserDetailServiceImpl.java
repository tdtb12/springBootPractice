package com.jimhsu.springBootPractice.spring.service.impl;

import com.jimhsu.springBootPractice.constants.Constants;
import com.jimhsu.springBootPractice.spring.dto.UserDTO;
import com.jimhsu.springBootPractice.spring.repository.UserRepository;
import com.jimhsu.springBootPractice.utils.LogBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
        UserDTO userDTO = userRepository.findByUserName(username);
        if (userDTO == null) {
            LogBack.LOGGER_INFO.info(username + " not found");
            throw new UsernameNotFoundException(username + " not found");
        }

        UserDetails userDetails = User.builder()
                    .username(userDTO.getUserName())
                    .password(userDTO.getPassword())
                    .build();

        return userDetails;
    }
}
