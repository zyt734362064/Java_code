package dao;

import entity.User;
import util.DBUtil;

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
public class UserDao {
    public int register(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int ret = 0;

        try {
            connection = DBUtil.getConnection();
            String sql  = "insert into user values (null,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(4,user.getGender());
            statement.setInt(3,user.getAge());
            statement.setString(5,user.getEmail());
            ret = statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            DBUtil.getClose(connection,statement,null);
        }
        return ret;
    }
    //登录界面
    public  User login(User loginUser){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;


        try {
            String sql = "select  * from user where username = ? and password = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,loginUser.getUsername());
            statement.setString(2,loginUser.getPassword());

            resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return user;
    }


     /*public static void main(String[] args) {
        UserDao userDao = new UserDao();
       User user = new User();
        user.setUsername("aaa");
        user.setPassword("123");
        User loginUser = userDao.login(user);
        System.out.println(loginUser);
    }*/
}
