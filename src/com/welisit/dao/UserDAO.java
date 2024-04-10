package com.welisit.dao;

import com.welisit.bean.User;

public interface UserDAO {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null,说明没有该用户
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回保存的个数
     */
    public int saveUser(User user);

    /**
     * 根据用户名密码查询用户
     * @param username
     * @param password
     * @return 返回搜索到的记录对象
     */
    public User queryUserByUnameAndPasswd(String username, String password);
}
