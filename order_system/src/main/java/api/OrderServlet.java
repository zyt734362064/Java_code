package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.Order;
import model.OrderDao;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-15
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    static class Response {
        public int ok;
        public String reason;
    }

    /**
     * API 8 新增订单
     * 普通用户才能新增
     * 管理员不能新增
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session == null){
                throw new OrderSystemException("您尚未登录");
            }
            User user = new User();
            if (user == null){
                throw new OrderSystemException("您尚未登录");
            }
            if (user.getIsAdmin() == 1){
                throw new OrderSystemException("您是管理员");
            }
            String body = OrderSystemUtil.readBody(req);
            Integer[] dishIds = gson.fromJson(body,Integer[].class);
            Order order = new Order();
            List<Dish>dishes = new ArrayList<>();
            for (Integer dishId:dishIds){
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishes.add(dish);
            }
            order.setDishes(dishes);
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }finally {
            resp.setContentType("application/json;charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
    /**
     * API 9
     * 查看所有订单
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            HttpSession session = req.getSession(false);
            if (session == null){
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null){
                throw new OrderSystemException("您尚未登录");
            }
            OrderDao orderDao = new OrderDao();
            List<Order> orders = null;
            if (user.getIsAdmin() == 0){
                orders = orderDao.selectByUserId(user.getUserId());
            }else {
                orders = orderDao.selectAll();
            }
            String jsonString = gson.toJson(orders);
            resp.getWriter().write(jsonString);

        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }
    }
}
