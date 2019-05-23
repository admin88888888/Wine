
package com.wine.service.impl;
import com.wine.dao.UserDao;
import com.wine.entity.User;
import com.wine.service.CodeService;
import com.wine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int register(User user) {
        User user1 = userDao.register(user.getName());
        if (user1 == null){
            return userDao.addUser(user);
        }else {
            throw new RuntimeException("用户名已存在");
        }
    }

    @Override
    public User login(String name, String password) {
        User user = userDao.register(name);
        if (user == null){
            throw new RuntimeException("用户名不存在");
        }else if(!password.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }else {
            return user;
        }
    }

    @Override
    public void changePassword(String name,String password1, String password2) {
        if(userDao.findOldPassword(name).equals(password1)){
                userDao.changePassword(name,password2);
        } else {
            throw new RuntimeException("原密码错误");
        }

    }


    @Override
    public void editUser(User user) {
        System.out.println(user);
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    @Override
    public List<User> selectUserAll() {
        List<User> users = userDao.selectUserAll();
        return users;
    }

    @Override
    public void updatePassword(String phone, String password) {
        userDao.updatePassword(phone,password);
    }

    @Override
    public List<User> selectByType(int type) {
        List<User> users = userDao.selectByType(type);
        return users;
    }


}
