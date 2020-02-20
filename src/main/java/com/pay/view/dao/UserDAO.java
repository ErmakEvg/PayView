package com.pay.view.dao;

import com.pay.view.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUserByUserName(String userName);
}