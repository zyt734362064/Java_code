package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-30
 */
@WebServlet("/findLoveMusic")
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset= utf-8");
        String loveMusicName = req.getParameter("loveMusicName");
        MusicDao musicDao = new MusicDao();

        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();
        List<Music> musicList = new ArrayList<>();

        if (loveMusicName != null){
            musicList = musicDao.selectKeyLoveMusic(loveMusicName,userId);
        }else {
            musicList = musicDao.findLoveMusic(userId);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),musicList);


    }
}
