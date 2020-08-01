package dao;

import entity.Mv;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-01
 */


public class MvDao  {

    /**
     *添加 MV 到 MV界面
     */

    public int insertMv(Mv mv){
        Connection connection = null;
        PreparedStatement statement = null;
        int ret = 0;
        try {
            String sql = "insert into mv values (null ,?,?,?,?,?)";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,mv.getSinger());
            statement.setString(2,mv.getTitle());
            statement.setString(3,mv.getTime());
            statement.setString(4,mv.getUrl());
            statement.setInt(5,mv.getUserid());
            ret = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,null);
        }
        return ret;
    }

    /**
     * 展示所有的 mv
     * @return
     */
    public List<Mv> mvList(){
        Connection connection = null;
        PreparedStatement statement = null;
        List<Mv> mvList = new ArrayList<>();
        ResultSet resultSet = null;
        try{
            String sql = "select * from mv";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            while (resultSet.next()){
                Mv mv = new Mv();
                mv.setId(resultSet.getInt("id"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setTime(resultSet.getString("time"));
                mv.setUrl(resultSet.getString("url"));
                mv.setUserid(resultSet.getInt("userid"));
                mvList.add(mv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return mvList;
    }


    /**
     * 根据 id 查找 MV
     */
    public Mv selectMvById(int mvId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Mv mv = null;
        try {
            String sql = "select * from mv where id = ?;";
            connection = DBUtil.getConnection();

            statement = connection.prepareStatement(sql);
            statement.setInt(1,mvId);
            if (resultSet.next()){
                mv = new Mv();
                mv.setId(resultSet.getInt("id"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setSinger(resultSet.getString("singer"));
                mv.setTime(resultSet.getString("time"));
                mv.setUrl(resultSet.getString("url"));
                mv.setUserid(resultSet.getInt("userid"));
            }


        }
            catch (SQLException e) {
                e.printStackTrace();

            }finally {
                DBUtil.getClose(connection,statement,resultSet);
        }
        return mv;
    }



}
