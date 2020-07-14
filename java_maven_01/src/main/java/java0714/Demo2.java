package java0714;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-14
 */
public class Demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setIntHeader("Refresh",1);
        Date date = new Date();
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write(date.toString());
        writer.write("</html>");
    }
}
