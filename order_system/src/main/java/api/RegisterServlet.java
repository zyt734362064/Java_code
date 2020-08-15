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
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-15
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();
    //读取JSON 请求对象
    static class Request{
        public String name;
        public String password;
    }
    //构造 JSON 响应对象
    static class Response{
        public int ok;
        public String reason;
    }

    //实际开发中，异常处理这样的语法对于处理逻辑中的一些出错情况是非常有帮助的
    //这样就可以让 try 中包含的都是纯粹的 正常逻辑，catch 中包含的都是错误逻辑
    //这种风格的diamante通常是在代码中的某一层统一处理异常
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Response response = new Response();
        //1.读取 body 中的数据
        try {
            String body = OrderSystemUtil.readBody(req);
            // 2.把body 中的数据解析成 Request 对象（GSON）
            Request request = gson.fromJson(body,Request.class);
            //3.查询数据库，看看当前的用户名是否存在（如果存在，就提示已经被注册了）
            UserDao userDao = new UserDao();
            User exitsUser = userDao.selectByName(request.name);
            if (exitsUser != null){
                //当前用户名重复了，直接返回一个表示注册失败的信息
                throw new OrderSystemException("当前用户名已经存在");
            }
            //4.把提交数据构造成 User 对象，提交给数据库中
            User user = new User();
            user.setName(request.name);
            user.setPassword(request.password);
            user.setIsAdmin(0);
            userDao.add(user);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        }finally {
            //5.构造响应数据。
            String jsonString = gson.toJson(response);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(jsonString);
        }

    }
}
