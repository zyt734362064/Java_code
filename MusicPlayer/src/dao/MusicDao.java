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
        List<Music> musicList = new ArrayList<>();
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
            throw new RuntimeException(e);
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
    public Music findMusicByID(int id){
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
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "delete from music where id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int ret = statement.executeUpdate();
            /*if (ret == 1){
                if (findLoveMusicOnDel(id)){
                    int ret2 = removeLoveMusicOnDel(id);
                    if (ret2 == 1){
                        return 1;
                    }
                }
                return 1;//表示这首个没有被添加到 loveMusic 这张表当中
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return 0;

    }
    public boolean findLoveMusicOnDel (int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "select * from lovemusic where music_id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,null);
        }
        return false;
    }

    public int removeLoveMusicOnDel(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;
        try{
            String sql = "delete from lovemusic where music_id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ret = statement.executeUpdate();
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,null);
        }
        return ret;
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
    public int insert(Music music){
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
     * 添加音乐到我喜欢的列表当中，
     * 添加之前要先判断该音乐而是否已经添加过了
     * @param userId
     * @param musicId
     * @return
     */
    public boolean findMusicByMusicId(int userId,int musicId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "select * from lovemusic where user_id = ? and music_id = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(1,musicId);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,null);
        }
        return false;
    }
    /**
     * 上传音乐到喜欢列表
     */

        public boolean insertLoveMusic(int userId,int musicId){
            Connection connection = null;
            PreparedStatement statement = null;
            int ret = 0;

            try{
                String sql = "insert into lovemusic (user_id, music_id) VALUES (?,?)";
                connection = DBUtil.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1,userId);
                statement.setInt(2,musicId);
                ret = statement.executeUpdate();
                if (ret == 1){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.getClose(connection,statement,null);
            }
            return false;
        }

        public int removeLoveMusic(int userId,int musicId){
            Connection connection = null;
            PreparedStatement statement = null;
            int ret = 0;
            try{
                String sql = "delete from lovemusic where user_id = ? and music_id = ?";
                connection = DBUtil.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1,userId);
                statement.setInt(2,musicId);
                ret = statement.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.getClose(connection,statement,null);
            }
            return ret;
        }



        public List<Music> findLoveMusic(int userId){
            Connection connection =  null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            List<Music> musicList = new ArrayList<>();
            try {
                String sql = "select m.id as music_id,title,singer,time,url,userid from lovemusic lm,music m where " +
                        "lm.music_id = m.id and user_id = ?";
                connection = DBUtil.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1,userId);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    Music music = new Music();
                    music.setId(resultSet.getInt("music_id"));
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
     * 根据关键字查询喜欢的歌单
     */
        public List<Music> selectKeyLoveMusic(String str,int userId){
            Connection connection =  null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            List<Music> musicList = new ArrayList<>();
            try {
                String sql = "select m.id as music_id,title,singer,time,url,userId from " +
                        "music m,lovemusic lm where lm.music_id = m.id and user_id = ? and title like '%" + str +"%' ";
                connection = DBUtil.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setInt(1,userId);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    Music music = new Music();
                    music.setId(resultSet.getInt("music_id"));
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
     * 测试部分
     * @param args
     */
  public static void main(String[] args) {
        MusicDao musicDao = new MusicDao();
      /*    Music music = musicDao.findMusic(1);
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
        System.out.println(ret);
        System.out.println(musicDao.deleteMusicById(3));
       List<Music> musicList = musicDao.selectKeyLoveMusic("红",1);
        System.out.println(musicList);*/
        List<Music> musicList = new ArrayList<>();
        musicList = musicDao.findMusic();
      System.out.println(musicList);
    }

}
