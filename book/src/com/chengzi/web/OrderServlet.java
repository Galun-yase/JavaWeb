package com.chengzi.web;

import com.chengzi.pojo.Cart;
import com.chengzi.pojo.User;
import com.chengzi.service.impl.OrderService;
import com.chengzi.service.impl.OrderServiceImpl;
import com.chengzi.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderService orderService=new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取购物车对象
        Cart cart=(Cart) req.getSession().getAttribute("cart");

        User loginUser=(User)req.getSession().getAttribute("user");

        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userid=loginUser.getId();
        //生成订单
        String orderId=orderService.createOrder(cart,userid);

        //req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
        //req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

    }
}
