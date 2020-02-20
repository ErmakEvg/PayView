package com.pay.view.dao;

import com.pay.view.model.User;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }


    public User getUserByUserName(String userName) {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User where stage is null and username = '" + userName + "'").list();
        return list.get(0);
    }
}
