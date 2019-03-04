package com.aca.talks.service;

import com.aca.talks.domain.User;
import com.aca.talks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long userId) {
        return this.userRepository.findById(userId).orElse(null);
    }
}
