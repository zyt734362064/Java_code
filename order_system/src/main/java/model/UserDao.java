package model;

import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "insert into user values (null,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getPassword());
            statement.setInt(2,user.getIsAdmin());
            statement.setString(3,user.getName());
            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("用户添加失败！");
            }
            System.out.println("用户添加成功！");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("用户添加失败！");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from user where name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
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
            throw new OrderSystemException("按姓名查找用户失败");
        }finally {
            DBUtil.close(connection,statement,resultSet);

        }
        return null;
    }

    public User selectById(int userId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from user where userId = ? ";
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
            throw new OrderSystemException("按 id 查找用户失败");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;


    }

    public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();
        //1、验证插入数据
        /*User user = new User();
        user.setName("zzz");
        user.setPassword("123");
        user.setIsAdmin(0);
        userDao.add(user);
        System.out.println("按照 id 查找：");
        User user = userDao.selectById(1);
        System.out.println(user);
        System.out.println("按照名字查找：");
        user = userDao.selectByName("zzz");
        System.out.println(user);*/
    }

}
