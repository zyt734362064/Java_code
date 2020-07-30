package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-29
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       req.setCharacterEncoding("utf-8");
       resp.setContentType("application/json;charset=utf-8");

       String userName = req.getParameter("username");
       String password = req.getParameter("password");

       UserService userService = new UserService();
       User loginUser = new User();
       loginUser.setUsername(userName);
       loginUser.setPassword(password);
        User user = userService.login(loginUser);
        Map<String,Object> return_map = new HashMap<>();

        if (user != null){
            System.out.println("登录成功！");
            req.getSession().setAttribute("user",user);
            return_map.put("msg",true);
        }else {
            System.out.println("登陆失败！");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
