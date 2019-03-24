package com.vosievskaya.dao;

import com.vosievskaya.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username) {
        return jdbcTemplate.queryForObject("SELCT * FROM USERS U WHERE U.USERNAME = ?", new UserMapper());
    }

    class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setUsername(resultSet.getString("USERNAME"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setToken(resultSet.getString("TOKEN"));
            user.setFirstName(resultSet.getString("FIRST_NAME"));
            user.setLastName(resultSet.getString("LAST_NAME"));
            return user;
        }
    }
}
