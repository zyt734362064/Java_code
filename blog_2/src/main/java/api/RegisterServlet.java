package api;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:浏览器是通过 POST 方法提交注册信息给服务器的
 * User:Zyt
 * Date:2020-07-22
 */
public class RegisterServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //校验账号和用户名是否合法
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null ||"".equals(name) ||
                password == null || "".equals(password)){
                //返回一个错误页面
            String html =  HtmlGenerator.getMessagePage("用户名或密码为空！",
                   "register.html" );
            resp.getWriter().write(html);
            return;
        }
        UserDao userDao = new UserDao();
        User exitsUser = userDao.selectByName(name);
        if (exitsUser != null){
            String html = HtmlGenerator.getMessagePage("名字重复，请换个名字",
                    "register.html");
            resp.getWriter().write(html);
            return;
        }
        //根据前端提交的数据，构造 User 对象并插入到数据库中
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.add(user);

        //返回一个提示页面，提示注册成功
        String html = HtmlGenerator.getMessagePage("注册成功！点击跳转到登录页面！",
                "login.html");
        resp.getWriter().write(html);
    }
}
