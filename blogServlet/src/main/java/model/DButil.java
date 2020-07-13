package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Description:管理数据库连接
 * 1、建立连接
 * 2、断开连接
 * JDBC 使用 DataSource来管理连接
 * DBUtil 相当于是对 DataSource 再稍微包装一层
 * DataSource 每个程序只应该有一个实例（单例）
 * DBUtil 本质上就是实现了一个单例模式，管理了唯一的一个 DataSource 实例
 * 此处使用懒汉模式
 * User:Zyt
 * Date:2020-07-13
 */
public class DButil {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java_blogdemo?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DButil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }

            }
        }
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement statement,
                             ResultSet resultSet){

    }
}
