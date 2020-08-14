package api;

import model.Article;
import model.ArticleDao;
import model.User;
import model.UserDao;
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
 * Date:2020-07-25
 */
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = req.getSession(false);
        //验证用户是否登录，如果登录就显示文章列表，如果没有登录就提示先登录
        if (httpSession == null){
            String html = HtmlGenerator.getMessagePage("请先登录！",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)httpSession.getAttribute("user");
        //判断请求中是否存在 articleId 参数
        String articleIdStr = req.getParameter("articleId");
        if (articleIdStr == null){
            getAllArticle(user,resp);
        }else {
            getOneArticle(Integer.parseInt(articleIdStr),user,resp);
        }
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        String html = HtmlGenerator.getArticleListPage(articles,user);
        resp.getWriter().write(html);
    }

    private void getOneArticle(int articleId, User user, HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        if (article == null){
            String html = HtmlGenerator.getMessagePage("文章不存在","article");
            resp.getWriter().write(html);
            return;
        }
        UserDao userDao = new UserDao();
        User author = userDao.selectById(article.getUserId());

        String html = HtmlGenerator.getArticleDetailPage(article,user,author);
        resp.getWriter().write(html);
    }
    //实现新增文章
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null){
            String html = HtmlGenerator.getMessagePage("您尚未登录，请先登录","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        //从请求中读取浏览器提交的数据并进行简单校验
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || "".equals(title)
                ||content == null || "".equals(content)){
            String html = HtmlGenerator.getMessagePage("提交的标题或正文为空","article");
            resp.getWriter().write(html);
            return;
        }
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setUserId(user.getUserId());
        articleDao.add(article);
        String html = HtmlGenerator.getMessagePage("发布成功！","article");
        resp.getWriter().write(html);
        return;

    }
}
