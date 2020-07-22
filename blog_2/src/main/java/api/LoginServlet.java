package api;

import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-22
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取到用户名和密码，并进行简单的校验
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name) ||
                password ==null || "".equals((password))){
            String html = HtmlGenerator.getMessagePage("用户名密码为空",
            "login.html");
            resp.getWriter().write(html);
            return;
        }
    }
}
