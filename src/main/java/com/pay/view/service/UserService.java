package com.pay.view.service;

import com.pay.view.model.User;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserByUserName(String userName);
}