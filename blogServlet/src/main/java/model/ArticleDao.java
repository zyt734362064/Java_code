package model;

import sun.security.pkcs11.Secmod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-15
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
                System.out.println("插入文章操作失败！");
                return;
            }else {
                System.out.println("插入文章成功！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,statement,null);
        }
    }
    //查看文章列表
    public List<Article> selectAll(){
        List<Article> articles = new ArrayList<>();
        Connection connection = DButil.getConnection();
        String sql = "select articleId,title,userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);

            resultSet =  statement.executeQuery();
            while (resultSet.next()){
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public  Article selectById(int articleId){
        Connection connection = DButil.getConnection();
        String sql = "select * from article where article = ?";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,statement,null);
        }
        return null;
    }

    public void delete(int articleId){
        Connection connection = DButil.getConnection();
        String sql = "delete form article where articleId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            int ret = statement.executeUpdate();
            if (ret != 1){
                System.out.println("删除文章失败！");
            }else {
                System.out.println("删除文章成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,statement,null);
        }
    }

    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setArticleId(1);
        article.setTitle("what?");
        article.setContent("hahahahhahahahahahahahahahaha");
        articleDao.add(article);
    }

}
