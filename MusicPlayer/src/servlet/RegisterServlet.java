package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import entity.User;

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
 * Date:2020-08-01
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String ageStr = req.getParameter("age");
        String email = req.getParameter("email");

        int age = Integer.parseInt(ageStr);

        UserDao userDao = new UserDao();
        User userRegister = new User();
        userRegister.setUsername(userName);
        userRegister.setPassword(password);
        userRegister.setGender(gender);
        userRegister.setAge(age);
        userRegister.setEmail(email);

        int ret = userDao.register(userRegister);
        Map<String,Object> return_map = new HashMap<>();
        if (ret == 1){
            System.out.println("注册成功！");
            return_map.put("msg",true);
        }else {
            System.out.println("注册失败！");
            return_map.put("msg",false);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);




    }
}
