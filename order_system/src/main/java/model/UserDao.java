package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * 1、插入用户 —— 注册的时候用
 * 2、按照名字查找用户 —— 登录的时候用
 * 3、按照用户 id 查找 —— 展示信息时使用
 * User:Zyt
 * Date:2020-08-08
 */
public class UserDao {
    public void add(User user) throws OrderSystemException {
        /**
         * JDBC 基本流程
         * 1、先获取数据库的连接（Datasource）
         * 2、拼装 SQL 语句（PrepareStatement）
         * 3、执行 SQL 语句 （executeQuery，executeUpdate）
         * 4、关闭连接 （close）如果是查询语句，还需要遍历结果集
         */
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "insert into user values (null,?,?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(3,user.getName());
            statement.setString(1,user.getPassword());
            statement.setInt(2,user.getIsAdmin());

            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("插入用户失败！");
            }else {
                System.out.println("插入用户成功！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    public User selectByName(String name) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * form user where name = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按用户名查找失败！");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public User selectById(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "select  * from user where userId = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }


}
