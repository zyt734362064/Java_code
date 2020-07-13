package java0713;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/**
 * Create with IntelliJ IDEA
 * Description:遍历获取到 header 中的所有内容
 * User:Zyt
 * Date:2020-07-13
 */
public class ServletDemo3  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        Writer writer = resp.getWriter();
        writer.write("<html>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            writer.write(header + ":" + req.getHeader(header));
            writer.write("<br/>");
        }
        writer.write("<html>");
    }
}
