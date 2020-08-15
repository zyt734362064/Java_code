package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Dish;
import model.DishDao;
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
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-15
 */
@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    static class Request {
        public String name;
        public int price;
    }
    static class Response {
        public int ok;
        public String reason;
    }

    /**
     * 5 号API 新增菜品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.检查用户的登录状态
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            HttpSession session = req.getSession(false);
            if (session == null){
                throw new OrderSystemException("当前未登录");
                }
            User user = (User) session.getAttribute("user");
            if (user == null){
                throw new OrderSystemException("当前未登录");
            }
            //2.检查用户是否是管理员
            if (user.getIsAdmin() == 0){
                throw new OrderSystemException("当前用户不是管理员");
            }
            //3.读取请求 body
            String body = OrderSystemUtil.readBody(req);
            Request request = gson.fromJson(body,Request.class);
        } catch (OrderSystemException e) {
            e.printStackTrace();
        }

    }
    /**
     * 6号 API删除菜品
     *
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //1.检查用户是否登录
            HttpSession session = req.getSession(false);
            if (session == null){
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null){
                throw new OrderSystemException("您尚未登录");
            }

            //2.检查用户是否是管理员
            if (user.getIsAdmin() == 0){
                throw new OrderSystemException("您不是管理员");
            }

            //3.读取到 dishId
            String dishIdStr = req.getParameter("dishId");
            if (dishIdStr == null){
                throw new OrderSystemException("dishID 参数不正确");
            }
            int dishId = Integer.parseInt(dishIdStr);

            //4.删除数据库中的对应记录
            DishDao dishDao = new DishDao();
            dishDao.delete(dishId);
            //5.返回一个响应结果
        } catch (OrderSystemException e) {
            e.printStackTrace();
        }
    }
    /**
     * API 7
     * 查看所有菜品
     * 登录才能查看
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        try {
            HttpSession session = req.getSession();
            if (session == null){
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }

            DishDao dishDao = new DishDao();
            List<Dish> dishes = dishDao.selectAll();

            String jsonString = gson.toJson(dishes);
            resp.getWriter().write(jsonString);
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = "";
        }finally {
            response.ok = 1;

        }
    }
}
