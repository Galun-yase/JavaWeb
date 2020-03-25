package com.chengzi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns=new ThreadLocal<>();

    static {
        try {
            Properties properties=new Properties();
            //读取配置文件jdbc.properties
            InputStream inputStream=JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);

            //创建数据库连接池
            dataSource= (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,则获取连接失败
     */
    public static Connection getConnection(){
        Connection conn=conns.get();

        if (conn==null){
            try {
                conn=dataSource.getConnection();//从数据库连接池获取连接
                conn.setAutoCommit(false);//设置为手动提交事务
                conns.set(conn);//将连接保存到ThreadLocal对象中，供后面的jdbc操作使用
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    /**
     * 提交事务，并释放连接
     */
    public static void commitAndClose(){
        Connection connection=conns.get();
        if (connection!=null){

            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接，放回数据库连接池
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //使用完后一定要移除该值，tomcat中使用线程池技术，线程不销毁只是放回线程池，故该value一直存在
        conns.remove();
    }


    /**
     * 回滚事务，并释放连接到数据连接池
     */
    public static void rollbackAndClose(){
        Connection connection=conns.get();
        if (connection!=null){

            try {
                connection.rollback();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();//关闭连接，放回数据库连接池
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //使用完后一定要移除该值，tomcat中使用线程池技术，线程不销毁只是放回线程池，故该value一直存在
        conns.remove();
    }

//    /**
//     * 关闭连接，放回到数据库连接池
//     */
//    public static void close(Connection conn){
//        if (conn!=null){
//            try{
//                conn.close();
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }
}
