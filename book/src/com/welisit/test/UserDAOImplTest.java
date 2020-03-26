package com.welisit.test;

import com.welisit.bean.User;
import com.welisit.dao.UserDAO;
import com.welisit.dao.impl.UserDAOImpl;
import org.junit.Test;

public class UserDAOImplTest {

    private UserDAO userDAO = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        User admin = userDAO.queryUserByUsername("海尔");
        System.out.println(admin);
    }

    @Test
    public void saveUser() {
        userDAO.saveUser(new User(null, "海尔", "123", "pass"));
    }

    @Test
    public void queryUserByUnameAndPasswd() {

        System.out.println(userDAO.queryUserByUnameAndPasswd("admin", "admin"));
    }
}