package model;

import sun.security.pkcs11.Secmod;
import sun.text.normalizer.UBiDiProps;

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
public class UserDao {
   public void add(User user){
       Connection connection = DButil.getConnection();
       String sql = "insert into User values (null,?,?)";

       PreparedStatement statement = null;
       try {
           statement = connection.prepareStatement(sql);
           statement.setString(1,user.getName());
           statement.setString(2,user.getPassword());
           int set = statement.executeUpdate();
           if (set != 1){
               System.out.println("插入新用户失败！");
           }
           System.out.println("插入新用户成功！");
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DButil.close(connection,statement,null);
       }
   }
   //按照名字查找用户
   public User selectByName(String name) {
       Connection connection = DButil.getConnection();
       String sql ="select * from user where name = ?";

       PreparedStatement statement = null;
       ResultSet resultSet = null;
       try {
           statement = connection.prepareStatement(sql);
           statement.setString(1,name);
           resultSet = statement.executeQuery();
           if (resultSet.next()){
               User user = new User();
               user.setUserId(resultSet.getInt("userId"));
               user.setName(resultSet.getString("name"));
               user.setPassword(resultSet.getString("password"));
               return user;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DButil.close(connection,statement,resultSet);
       }
        return null;
   }
   public User selectById(int userId){
       Connection connection = DButil.getConnection();
       String sql = "select * from user where userId = ?";
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       try {
           statement = connection.prepareStatement(sql);
           statement.setInt(1,userId);
           resultSet = statement.executeQuery();
           if (resultSet.next()){
               User user = new User();
               user.setUserId(resultSet.getInt("userId"));
               user.setName(resultSet.getString("name"));
               user.setPassword(resultSet.getString("password"));
               return user;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DButil.close(connection,statement,resultSet);
       }
       return null;
   }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        //测试 add 方法
/*        User user = new User(); //
        user.setName("zyt");
        user.setPassword("123");
        userDao.add(user);
        // 测试查询方法
        userDao.selectByName("zyt");
        System.out.println(user);
        userDao.selectById(1);
        System.out.println(user);*/

    }
}
