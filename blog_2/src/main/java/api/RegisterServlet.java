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
public class RegisterServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name)
                || password == null || "".equals(password)){
            String html = HtmlGenerator.getMessagePage("输入的用户名或者密码为空",
                    "register.html");
            resp.getWriter().write(html);
            return;
        }
        UserDao userDao = new UserDao();
        User exitsUser = userDao.selectByName(name);
        if (exitsUser != null){
            String html = HtmlGenerator.getMessagePage("输入的用户名已存在！请换个名字！",
                    "register.html");
            resp.getWriter().write(html);
            return;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.add(user);
        String html = HtmlGenerator.getMessagePage("注册成功，点击跳转登录页面!",
                "login.html");
        resp.getWriter().write(html);

    }
}
