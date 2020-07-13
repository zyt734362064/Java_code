package java0713;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:延时服务器给浏览器写回 cookie
 * User:Zyt
 * Date:2020-07-13
 */
public class ServletDemo7  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、先构造 cookie 对象,每个 cookie 对象就是一个键值对
        Cookie userName = new Cookie("userName","zyt");
        Cookie age = new Cookie("age",18 + "" );

        //2、把 cookie 放到响应中
        resp.addCookie(userName);
        resp.addCookie(age);

        //3、创建一个响应报文
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("返回 cookie 成功！");
    }
}
