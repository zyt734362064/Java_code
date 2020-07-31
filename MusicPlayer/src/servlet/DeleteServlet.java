package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        String strId = req.getParameter("id");
        int id = Integer.parseInt(strId);
        MusicDao musicDao = new MusicDao();
        //删除之前查看当前 id 是否存在
        Music music =  musicDao.findMusicByID(id);
        if (music == null){
            return;
        }
        int delete = musicDao.deleteMusicById(id);
        Map<String,Object> return_map = new HashMap<>();
        System.out.println(music.getUrl());
        if (delete == 1){
            //代表数据库删除了，但是服务器上的音乐还存在
            //File file = new File("E:\\java_code\\dataCode\\Java_code\\MusicPlayer\\web\\" + music.getUrl() + ".mp3");
            File file = new File("/root/java/apache-tomcat-8.5.57/webapps/rainbowMusic/" + music.getUrl() + ".mp3");
            if (file.delete()){
                return_map.put("msg",true);
                System.out.println("服务器删除成功！");

            }else {
                return_map.put("msg",false);
                System.out.println("服务器删除失败！");
            }
        }else {
            return_map.put("msg",false);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);
    }
}
