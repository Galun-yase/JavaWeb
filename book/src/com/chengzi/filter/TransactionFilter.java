package com.chengzi.filter;

import com.chengzi.utils.JdbcUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();//回滚事务
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好页面
        }
    }

    @Override
    public void destroy() {

    }
}
