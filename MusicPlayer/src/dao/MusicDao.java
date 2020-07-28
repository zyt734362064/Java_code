package dao;

import entity.Music;
import util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-27
 */
public class MusicDao {
    //查询全部歌单
    public List<Music> findMusic(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = null;
        try{
            String sql = "select * from  music";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Music music= new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getTime("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));
                musicList.add(music);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return musicList;
    }

    public int deleteMusicById(int id){
        return 0;
    }
}
