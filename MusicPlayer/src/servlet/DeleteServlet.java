package servlet;

import dao.MusicDao;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-29
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        MusicDao musicDao = new MusicDao();
        musicDao.findMusicByID(id);
        Music music = new Music();
        int delete =  musicDao.deleteMusicById(id);
        Map<String,Object> return_map = new HashMap<>();

        if (delete == 1){
            File file = new File("E:\\java_code\\dataCode\\Java_code\\MusicPlayer\\web\\music"+music.getUrl() + ".mp3");
            if (file.delete()){
                return_map.put("msg",true);
                System.out.println("服务器删除成功！");
            }else {

                return_map.put("msg",false);
                System.out.println("服务器删除失败！");
            }
        }
    }
}
