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
 * User:Zyt
 * Date:2020-08-08
 */
public class DishDao {
    public void add(Dish dish) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "insert into disher values (null ,?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,dish.getName());
            statement.setInt(2,dish.getPrice());
            int ret = statement.executeUpdate();
            if (ret == 1){
                System.out.println("插入菜品成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除菜品失败！");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public void delete(int dishId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "delete from dishes where dishId = ? ";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,dishId);
            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("删除菜品失败！");
            }
            System.out.println("插入菜品成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public List<Dish> dishes(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Dish> dishList = new ArrayList<>();
        try {
            String sql = "select * from dishes";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishList.add(dish);
            }
            return dishList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
        return null;
    }
}
