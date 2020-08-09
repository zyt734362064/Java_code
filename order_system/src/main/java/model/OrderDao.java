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
 * Description:操作订单
 * 1、新增订单
 * 2、查看所有订单
 * 3、查看指定用户的订单
 * 4、查看订单的详细信息
 * 5、修改订单状态（订单是否已经完成）
 * User:Zyt
 * Date:2020-08-08
 */
public class OrderDao {
    /**
     * 新增订单，订单是和两个表关联的
     * 第一个表示 order_user
     * 第二个表示 order_dish，一个订单中可能会涉及点多个菜，就需要给这个表一次性插入多个记录
     *
     * @param order
     */
    public void add(Order order) throws OrderSystemException {
        addOrderUser(order);
        addOrderDish(order);


    }

    private void addOrderUser(Order order) throws OrderSystemException {
       Connection connection = DBUtil.getConnection();
       PreparedStatement statement = null;
       ResultSet resultSet = null;
       try {
           String sql = "insert into order_user values (null,?,now(),0)";
           statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
           statement.setInt(1,order.getUserId());
           int ret = statement.executeUpdate();
           if (ret != 1){
               throw new OrderSystemException("插入订单失败！");
           }
           resultSet = statement.getGeneratedKeys();
           if (resultSet.next()){
               order.setOrderId(resultSet.getInt(1));
           }
           System.out.println("插入订单第一步成功！");
       } catch (SQLException e) {
           e.printStackTrace();
           throw new OrderSystemException("插入订单失败！");
       }finally {
           DBUtil.close(connection,statement,resultSet);
       }
    }

    private void addOrderDish(Order order) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        List<Dish> dishList = new ArrayList<>();
        try {
            String sql = "insert into order_dish values (?,?)";
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            for (Dish dish : dishList){
                statement.setInt(1,order.getOrderId());
                statement.setInt(2,dish.getDishId());
                statement.addBatch();
            }
            statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            deleteOrderUser(order.getOrderId());
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    private void deleteOrderUser(int orderId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "delete from order_user where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("回滚失败！");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public List<Order> selectAll(){
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> orders = new ArrayList<>();

        try {
            String sql = "select * from order_user";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return orders;
    }

    public List<Order> selectByUserId(int userId){
        List<Order> orders = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_user where userId = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return orders;
    }


    public Order selectByOrderId(int orderId) throws OrderSystemException {
        //根据 orderId 获取到 Order 对象
        Order order = buildOrder(orderId);
        //根据 orderId 得到 该 orderId 对应的菜品 id 列表
        List<Integer> dishIds = selectDishIds(orderId);
        //根据菜品 id 查询 dishes 表，获取到 菜品详情
        order = getDishDetail(order,dishIds);
        return order;
    }

    /**
     * 根据 orderId 来查询对应的 order 对象的基本信息
     * 查找 orderUser 表
     * @param orderId
     * @return
     */
    private Order buildOrder(int orderId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_user where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //查找 order_dish表
    private List<Integer> selectDishIds(int orderId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Integer> dishIds = new ArrayList<>();

        try {
            String sql = "select * from order_dish  where orderId = ? ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                dishIds.add(resultSet.getInt("dishId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return dishIds;
    }

    private Order getDishDetail(Order order, List<Integer> dishIds) throws OrderSystemException {
        //1、准备好要返回的结果
        List<Dish> dishes = new ArrayList<>();
        DishDao dishDao = new DishDao();
        //2、遍历 dishIds 在 dishes 表中查
        for (Integer dishId : dishIds){
            Dish dish = dishDao.selectById(dishId);
        }
        order.setDishes(dishes);
        return order;
    }
    public void changeState(int orderId,int isDone) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "update order_user set isDone = ? where orderId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,isDone);
            statement.setInt(2,orderId);
            int ret = statement.executeUpdate();
            if (ret != 1){
                throw new OrderSystemException("修改订单状态失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("修改订单状态失败！");
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    public static void main(String[] args) throws OrderSystemException {
        OrderDao orderDao = new OrderDao();
        /*Order order = new Order();
        List<Dish>dishes = new ArrayList<>();
        order.setUserId(1);
        orderDao.add(order);*/
    }

}
