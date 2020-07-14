package java0714;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-14
 */
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        resp.setContentType("text/html;charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("firtName: " + firstName);
        writer.write("<br/>");
        writer.write("lastName: " + lastName);
        writer.write("</html>");
    }
}
