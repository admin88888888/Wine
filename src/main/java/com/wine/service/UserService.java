package com.wine.service;


import com.wine.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
public interface UserService {
    public int register(User user);
    public User  login(String name,String password);

    void changePassword(String name,String password1, String password2);

    void editUser(User user);

    void deleteUser(String name);

    List<User> selectUserAll();

    void updatePassword(String phone, String password);

    List<User> selectByType(int type);
}
