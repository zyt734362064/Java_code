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
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "insert into order_user  values (null,?,now(),0)";
            connection = DBUtil.getConnection();
            //加上 RETURN_GENERATED_KEYS 选项，插入的同时就会把数据库生成的的自增主键的值获取到
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入订单失败");
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("插入订单第一步成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入订单失败");
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }

    }

    private void addOrderDish(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into arder_dish values(?,?)";
        try {
            connection = DBUtil.getConnection();
            //3、关闭自动提交，手动关闭 就可以一次行发送多个sql 语句了
            //默认情况下是默认提交的，需要调用 execute
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            List<Dish> dishes = order.getDishes();
            //4、遍历dishes 给 sql 添加 多个 values 值
            for (Dish dish : dishes) {
                statement.setInt(1, order.getOrderId());
                statement.setInt(2, dish.getDishId());
                statement.addBatch();//给 sql 新增一个片段
            }
            //5、执行 sql ，并不是真正的执行
            statement.executeBatch();
            //6、发送给服务器（真正执行）
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private void deleteOrderUser(int orderId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "delete from order_user where orderId = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }


    }
    public List<Order> selectAll(){
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_user";
             connection = DBUtil.getConnection();
             statement = connection.prepareStatement(sql);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
                 Order order = new Order();
                 order.setOrderId(resultSet.getInt("orderId"));
                 order.setUserId(resultSet.getInt("userId"));
                 order.setTime(resultSet.getTimestamp("time"));
                 order.setIsDone(resultSet.getInt("isDone"));
                 orders.add(order);
                 return orders;
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Order> selectByUserId(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Order> orders = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select * from order where userId = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
                return orders;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return orders;
    }
    //这个额方法要把这个 Order 对象完整的填写进去
    public Order selectById(int orderId){
        Order order = buildOrder(orderId);
        List<Integer> dishIds = selectDishIds(orderId);
        order = getDishDetail(order,dishIds);
        return order;
    }

    private Order getDishDetail(Order order, List<Integer> dishIds) {
        return null;
    }
    //查 order_dish 表
    private List<Integer> selectDishIds(int orderId) {
        Connection connection = null;
        PreparedStatement statement = null;
        List<Integer> dishIds = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_dish where orderId = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,orderId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int dishId = 0;
                dishId = resultSet.getInt("dishId");
                dishIds.add(dishId);
            }
            return dishIds;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //查找 order_user 表
    private Order buildOrder(int orderId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from order_user where orderId = ?;";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
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
}
