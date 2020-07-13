package java0713;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-13
 */
@MultipartConfig
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收到图片直接把图片保存到
        //d:/java0713/images 目录中
        //先把目录准备好
        String basePath = "e:/javaTest/images";
        Part image = req.getPart("image");

        String path = basePath + image.getSubmittedFileName();
        image.write(path);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("图片上传成功！");
    }
}
