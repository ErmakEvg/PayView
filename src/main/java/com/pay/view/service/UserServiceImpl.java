package com.pay.view.service;

import java.util.List;
import com.pay.view.dao.UserDAO;
import com.pay.view.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }


    public User getUserByUserName(String userName) {
        return userDAO.getUserByUserName(userName);
    }

}