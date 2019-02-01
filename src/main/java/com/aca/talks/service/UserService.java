package com.aca.talks.service;

import com.aca.talks.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getById(Long id);
    public void delete(User user);
    public User save(User user);
    public User update(User user);
}
