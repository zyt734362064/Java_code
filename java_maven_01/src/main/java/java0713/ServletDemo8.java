package java0713;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Create with IntelliJ IDEA
 * Description:通过读取请求，获取到浏览器发来的 cookie 内容
 * User:Zyt
 * Date:2020-07-13
 */
public class ServletDemo8  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        for (Cookie cookie : cookies){
            writer.write(cookie.getName() + ": " + cookie.getValue());
            writer.write("<br/>");
        }
        writer.write("</html>");
    }
}
