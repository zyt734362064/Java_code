package java0713;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:返回一个 404 页面
 * User:Zyt
 * Date:2020-07-13
 */
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到一个 Tomcat 内置的错误界面
        resp.sendError(404,"页面没找到(灬ꈍ ꈍ灬)");
    }
}
