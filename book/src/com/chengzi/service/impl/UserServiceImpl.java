package com.chengzi.service.impl;

import com.chengzi.dao.impl.UserDao;
import com.chengzi.dao.impl.UserDaoImpl;
import com.chengzi.pojo.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
