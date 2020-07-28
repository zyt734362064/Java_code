package dao;

import entity.Music;
import util.DBUtil;


import java.sql.*;
import java.util.ArrayList;
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
                music.setTime(resultSet.getString("time"));
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

    /**
     * 根据 id 查找音乐
     * @param id
     * @return
     */
    public Music findMusic(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Music music = null;
        try{
            String sql = "select * from music where id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                music= new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return music;
    }


    public int deleteMusicById(int id){
        return 0;
    }
    /**
     * 根据关键字查询歌单（支持模糊查询）
     */
    public List<Music> keySelectMusic(String str){
        Connection connection =  null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = new ArrayList<>();
        try {
            String sql = "select * from music where title like '%" + str + "%'";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserid(resultSet.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return musicList;
    }

    /**
     * 上传音乐
     *
     */

    public int Insert(Music music){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            String sql = "insert into music value (null ,?,?,?,?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,music.getTitle());
            statement.setString(2,music.getSinger());
            statement.setString(3, music.getTime());
            statement.setString(4,music.getUrl());
            statement.setInt(5,music.getUserid());
            int ret = statement.executeUpdate();
            //返回值代表影响的层数
            if (ret == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,null);
        }
        return 0;
    }

    /**
     * 测试部分
     * @param args
     */
    public static void main(String[] args) {
        MusicDao musicDao = new MusicDao();
       /* Music music = musicDao.findMusic(1);
        System.out.println(music);
       List<Music> musicList = musicDao.keySelectMusic("红");
        System.out.println(musicList);
       Music music = new Music();
       music.setTitle("最炫民族风");
       music.setSinger("凤凰传奇");
       music.setTime("2020-07-28");
       music.setUrl("music\\最炫民族风");
       music.setUserid(1);
       int ret = musicDao.Insert(music);
        System.out.println(ret);*/
    }

}
