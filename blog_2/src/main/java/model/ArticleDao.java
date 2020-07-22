package model;

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
 * Date:2020-07-22
 */
public class ArticleDao {
    public void add(Article article){
        Connection connection = DButil.getConnection();
        String sql = "insert into article values (null,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setInt(3,article.getUserId());
            int ret = statement.executeUpdate();
            if (ret != 1){
                System.out.println("文章插入失败！");
            }
            System.out.println("文章插入成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,statement,null);
        }
    }
   public List<Article> selectAll(){
        List<Article> articles = new ArrayList<>();
        Connection connection = DButil.getConnection();
        String sql = "select articleId,title,userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       try {
           statement = connection.prepareStatement(sql);
           resultSet = statement.executeQuery();
           while (resultSet.next()){
               Article article = new Article();
               article.setArrticleId(resultSet.getInt("articleId"));
               article.setTitle(resultSet.getString("title"));
               article.setUserId(resultSet.getInt("userId"));
               articles.add(article);
           }
           return articles;
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DButil.close(connection,statement,resultSet);
       }
       return null;
   }
   public Article selectById(int articleId){
        Connection connection = DButil.getConnection();
        String sql = "select * form article where articleId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
       try {
           statement = connection.prepareStatement(sql);
           statement.setInt(1,articleId);
           resultSet = statement.executeQuery();
           if (resultSet.next()){
               Article article = new Article();
               article.setArrticleId(resultSet.getInt("articleId"));
               article.setTitle(resultSet.getString("title"));
               article.setContent(resultSet.getString("content"));
               article.setUserId(resultSet.getInt("userId"));
               return article;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DButil.close(connection,statement,resultSet);
       }
       return null;
   }
   public void delete(int articleID){
        Connection connection = DButil.getConnection();
        String sql = "delete from article where articleId = ?";
        PreparedStatement statement = null;
       try {
           statement = connection.prepareStatement(sql);
           statement.setInt(1,articleID);
           int ret = statement.executeUpdate();
           if (ret != 1){
               System.out.println("文章删除失败！");
           }
           System.out.println("文章删除成功！");
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DButil.close(connection,statement,null);
       }
   }

    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle("我是标题");
        article.setContent("正文在这里正文在这里正文在这里正文在这里正文在这里正文在这里" +
                "正文在这里正文在这里正文在这里正文在这里正文在这里");
        article.setUserId(1);
        articleDao.add(article);
    }
}
