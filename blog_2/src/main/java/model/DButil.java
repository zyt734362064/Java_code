package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.xml.internal.ws.util.ReadAllStream;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-17
 */
public class DButil {
    private static volatile DataSource dataSource = null;
    private static String URL = "jdbc:mysql://127.0.0.1:3306/blogdemo?characterEnconding=utf-8&useSSL=true";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static DataSource getDataSource(){
        if (dataSource == null){
            synchronized (DButil.class){
                if (dataSource == null){
                    dataSource = new MysqlDataSource();

                    ((MysqlDataSource) dataSource).setURL(URL);
                    ((MysqlDataSource) dataSource).setUser(USERNAME);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }
    public static Connection getConnection(){

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static void close(Connection connection,PreparedStatement statement,
                             ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
