package com.welisit.service.impl;

import com.welisit.bean.User;
import com.welisit.dao.impl.UserDAOImpl;
import com.welisit.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUnameAndPasswd(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        User user = userDAO.queryUserByUsername(username);
        return user != null;
    }
}
