package com.welisit.service;

import com.welisit.bean.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    /**
     * 登录用户
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean existUsername(String username);
}
