package com.aca.talks.service;

import com.aca.talks.domain.User;

public interface UserService {
    public User findById(Long userId);
}
