package model;

import sun.security.pkcs11.Secmod;

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

            int ret = statement.executeUpdate();
            if (ret != 1){
                System.out.println("新用户插入失败！");
            }
            System.out.println("新用户插入成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,statement,null);
        }
    }
}
