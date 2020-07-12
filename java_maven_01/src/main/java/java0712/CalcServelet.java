package java0712;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-12
 */
public class CalcServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取 url  中的参数内容(a b 内容）
        //然后针对 a 和 b 进行相加
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int result = a + b;
        resp.getWriter().write(String.format("<h1>result = %d</h1>",result));
    }
}
