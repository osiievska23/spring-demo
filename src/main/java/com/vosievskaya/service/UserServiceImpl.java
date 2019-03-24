package com.vosievskaya.service;

import com.vosievskaya.dao.UserDao;
import com.vosievskaya.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getByUSerName(String username) {
        return userDao.getUserByUsername(username);
    }
}
