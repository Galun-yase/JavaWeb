package com.chengzi.test;

import com.chengzi.dao.impl.UserDao;
import com.chengzi.dao.impl.UserDaoImpl;
import com.chengzi.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao=new UserDaoImpl();


    @Test
    public void queryUserByUsername(){
        if (userDao.queryUserByUsername("admin12")==null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword(){
        if (userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误，登录失败");
        }else {
            System.out.println("查询成功");
        }
    }


    @Test
    public void saveUser(){
        System.out.println(userDao.saveUser(new User(null,"root","123456","cc@cc.com")));
    }

}
