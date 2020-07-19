package api;

import model.Article;
import model.ArticleDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-19
 */
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.验证用户是否已经登陆了，如果尚未登录，就提示用户要先登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null){
            String html = HtmlGenerator.getMessagePage("请先登录",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)httpSession.getAttribute("user");
        String articleId = getInitParameter("articleId");
        if (articleId == null){
            getAllArticle(user,resp);
        }else{
            getOneArticle(Integer.parseInt(articleId),user,resp);
        }

    }

    private void getOneArticle(int articleId,User user,HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        if (article == null){
            String html =  HtmlGenerator.getMessagePage("文章不存在",
                    "article");
            resp.getWriter().write(html);
        }
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();

        String html = HtmlGenerator.getArticleListPage(articles,user);
        resp.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null){
            String html = HtmlGenerator.getMessagePage("您尚未登录",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)httpSession.getAttribute("user");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || "".equals(title)){
            String html = HtmlGenerator.getMessagePage("提交的标题或者正文为空",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

    }
}
