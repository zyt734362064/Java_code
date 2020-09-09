package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-09
 */
public class ArticleDaoTest {

    @Test
    public void add() {
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle("文章标题");
        article.setUserId(1);
        article.setContent("正文正文正文正文！");
        articleDao.add(article);
    }

    @Test
    public void selectAll() {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        System.out.println(articles);
    }

    @Test
    public void selectById() {
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(1);
        System.out.println(article);
    }

    @Test
    public void delete() {
        ArticleDao articleDao = new ArticleDao();
        articleDao.delete(1);
    }
}