package java0713;

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
 * Date:2020-07-13
 */
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理表单提交的数据

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        //构造响应页面
        resp.setContentType("text/html;charset=utf-8");
        //【注意！】一旦调用了 getWriter 方法，此时 header 的内容就不能再改了
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("firstName: " + firstName);
        writer.write("</br>");
        writer.write("secondName: " + secondName);
        writer.write("</html>");
    }
    //此时，无论参数是在 url 中，还是 body 中都能获取到
    // 此处 get post 处理方式都是一样的

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
