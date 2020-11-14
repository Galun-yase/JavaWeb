package com.chengzi.dao.impl;

import com.chengzi.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql="select id,username,password,email from tb_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select id,username,password,email from tb_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into tb_user(username,password,email,tel,idcard) values (?,?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getTelphone(),user.getIdcart());
    }
}
