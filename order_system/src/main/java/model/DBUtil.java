package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-08
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/order_system?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static DataSource dataSource = null;
    public static DataSource getDataSource(){
        if (dataSource == null){
            synchronized (DBUtil.class){
                if (dataSource == null){
                    dataSource = new MysqlDataSource();
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(Connection connection,PreparedStatement statement, ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e) {
                e.printStackTrace();
        }
    }

}
