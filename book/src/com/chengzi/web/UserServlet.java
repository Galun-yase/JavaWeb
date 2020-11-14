package com.chengzi.web;

import com.chengzi.pojo.User;
import com.chengzi.service.impl.UserService;
import com.chengzi.service.impl.UserServiceImpl;
import com.chengzi.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceImpl();



    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        boolean existsUsername=userService.existsUsername(username);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson=new Gson();
        String json=gson.toJson(resultMap);

        resp.getWriter().write(json);


    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注销，销毁session中登录信息
        req.getSession().invalidate();
        //重定向到首页
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //查询用户名及密码是否正确
        User loginUser=userService.login(new User(null,username,password,null));
        if (loginUser==null){

            //把错误信息，和回显的表单项信息，保存到request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);

            //登录失败，跳转回登录界面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            //保存登录信息
            req.getSession().setAttribute("user",loginUser);


            //登录成功，则跳转到登录成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的参数
        String token=(String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        //1、获取请求的参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
        String telphone=req.getParameter("telphone");
        String idcart=req.getParameter("idcart");

//        User user= WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2、检查验证码
        if(token!=null && token.equalsIgnoreCase(code)){
            //3、检查用户名是否可用
            if (userService.existsUsername(username)){

                //把回显信息放到request域中
                req.setAttribute("msg","用户名已存在！！！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                System.out.println("用户名"+username+"已存在");
                //用户名不可用跳转到注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,password,email,telphone,idcart));
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }



        }else {
            //把回显信息放到request域中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码"+code+"错误");
            //验证码错误跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
