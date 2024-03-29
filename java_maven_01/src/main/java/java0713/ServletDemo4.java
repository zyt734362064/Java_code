package java0713;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Description:返回一个页面，每秒钟自动刷新
 * User:Zyt
 * Date:2020-07-13
 */
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;chaset=utf-8");
        resp.setIntHeader("Refresh",1);
        //返回的页面中，填写当前时间
        //获取当前时间
        //1.System.currentTimeMillis();
        //new Date();
        //new Calender();
        Date date = new Date();
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write(date.toString());
        writer.write("</html>");
    }
}
