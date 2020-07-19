package api;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-19
 */
public class LoginServert  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.找到用户名和密码
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name) ||
                password == null || "".equals(password)){
            String html = HtmlGenerator.getMessagePage("用户名密码为空",
                    "login,html");
            resp.getWriter().write(html);
            return;
        }
        //2.数据库中查找，看用户是否存在
        //3.对比密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(name);
        if (user == null || password.equals(user.getPassword())){
            //用户名不存在
            String html = HtmlGenerator.getMessagePage("用户名或密码错误",
                    "login.html");
        }


        //4.匹配成功则登录成功，创建一个 session
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("user",user);
        //5.返回一个成功登录的页面
        String html = HtmlGenerator.getMessagePage("登录成功",
                "article");
        resp.getWriter().write(html);
    }
}
