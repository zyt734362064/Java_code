package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Create with IntelliJ IDEA
 * Description:通过 UserDao 这个类来在完成用户的数据表操作
 * User:Zyt
 * Date:2020-07-15
 */
public class UserDao {
    //1、新增用户
    //2、按照名字查找用户（登录）
    public void add(User user){
        //1.获取数据库连接
        Connection connection = DButil.getConnection();
        //2.拼装 SQL 语句
        String sql = "insert into user values (null,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            //3.执行 SQL 语句
            int ret = statement.executeUpdate();
            if (ret != 1){
                System.out.println("插入新用户失败！");
                return;
            }
            System.out.println("插入新用户成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放数据库的连接
            DButil.close(connection,statement,null);
        }


    }

    public User selectByName(String name){
        Connection connection = DButil.getConnection();

        String sql = "select * from user where name = ?";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);

            resultSet = statement.executeQuery();

            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userID"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("Password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,statement,null);
        }
        return null;
    }
   public static void main(String[] args) {
        UserDao userDao = new UserDao();
/*         User user = new User();
        user.setName("zzz");
        user.setPassword("123");
        userDao.add(user);

*/
    }
}
