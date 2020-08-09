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
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "insert into dishes values (null,?,?);";
            statement = connection.prepareStatement(sql);

            statement.setString(1,dish.getName());
            statement.setInt(2,dish.getPrice());
            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("插入菜品失败！");
            }
            System.out.println("插入菜品成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入菜品失败");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    public void delete(int dishId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "delete from dishes where dishId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,dishId);
            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("删除菜品失败！");
            }
            System.out.println("删除菜品成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("删除菜品失败！");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public List<Dish> selectAll() throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Dish> dishes = new ArrayList<>();
        try {
            String sql = "select * from dishes";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("显示菜单出错！");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return dishes;
    }

    public Dish selectById(int dishId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from dishes where dishId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,dishId);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按 id 查询菜品出错");
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
        /*dishDao.delete(1);
        dishDao.delete(2);
        Dish dish = new Dish();
        dish.setName("锅包肉");
        dish.setPrice(3800);
        dishDao.add(dish);
        List<Dish>dishes = dishDao.selectAll();
        System.out.println("查看所有菜品：");
        System.out.println(dishes);
        System.out.println("根据 id 查找菜品：");
        Dish dish = dishDao.selectById(3);
        System.out.println(dish);*/


    }
}
