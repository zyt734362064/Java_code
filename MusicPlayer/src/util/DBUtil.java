package util;

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
 * Date:2020-07-27
 */
public class DBUtil {
    private static String url = "jdbc:mysql://127.0.0.1:3306/musicplayer?useSSL=flase";
    private static String user = "root";
    private static String password = "";

    private static volatile DataSource dataSource;

    private static DataSource getDataSource(){
        if  (dataSource == null){
            synchronized (DBUtil.class){
                if (dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(url);
                    ((MysqlDataSource)dataSource).setUser(user);
                    ((MysqlDataSource)dataSource).setPassword(password);

                }
            }
        }
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            Connection connection = getDataSource().getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败！");
        }

    }
    public static void getClose(Connection connection, PreparedStatement statement, ResultSet resultSet){

            try {
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
