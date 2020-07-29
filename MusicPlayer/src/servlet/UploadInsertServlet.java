package servlet;

import dao.MusicDao;
import entity.Music;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Description:
 * 将音乐信息写入到数据库当中
 * User:Zyt
 * Date:2020-07-29
 */
@WebServlet("/uploadsucess")
public class UploadInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String singer = req.getParameter("singer");
        String fileName = (String) req.getSession().getAttribute("fileName");
        String[] strings = fileName.split("\\.");
        String title = strings[0];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());
        User user = (User) req.getSession().getAttribute("user");
        int user_id = user.getId();
        String url = "music/"+title;
        MusicDao musicDao = new MusicDao();
        Music music = new Music();
        int ret = musicDao.insert(music);
    }
}
