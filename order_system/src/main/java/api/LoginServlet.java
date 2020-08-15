package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import model.UserDao;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-15
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    static class Request {
        public String name;
        public String password;
    }
    static class Response {
        public int ok;
        public  String reason;
        public String name;
        public int isAdmin;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        try {
            String body = OrderSystemUtil.readBody(req);
            Request request = gson.fromJson(body,Request.class);
            UserDao userDao = new UserDao();
            User user = userDao.selectByName(request.name);

            if (user == null || !user.getPassword().equals(request.password)){
                throw  new OrderSystemException("用户名或密码错误");
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = 0;

        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }finally {
            resp.setContentType("application.json;charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    //对应检测登录状态的 API

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response  response = new Response();
        //获取当前用户的 session，如果 session 不存在，认为未登录
        try {
            HttpSession session = req.getSession(false);
            if (session == null){
                throw new OrderSystemException("当前未登录");
            }
            UserDao userDao = new UserDao();
            User user = (User) session.getAttribute("user");
            if (user == null){
                throw new OrderSystemException("当前未登录");
            }
        } catch (OrderSystemException e) {
            e.printStackTrace();
        }
    }
}
