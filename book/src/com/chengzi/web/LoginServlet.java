package com.chengzi.web;

import com.chengzi.pojo.User;
import com.chengzi.service.impl.UserService;
import com.chengzi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //查询用户名及密码是否正确
        User loginUser=userService.login(new User(null,username,password,null));
        if (loginUser==null){
            //登录失败，跳转回登录界面
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else {
            //登录成功，则跳转到登录成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }

    }
}
