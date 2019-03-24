package com.vosievskaya.dao;

import com.vosievskaya.model.User;

public interface UserDao {

    User getUserByUsername(String username);
}
