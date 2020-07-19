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

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-19
 */
public class DelectArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null){
            String html = HtmlGenerator.getMessagePage("您尚未登录",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)httpSession.getAttribute("user");
        String articleIdStr = req.getParameter("articleId");
        if (articleIdStr == null){
            String html = HtmlGenerator.getMessagePage("要删除的文章id不存在",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(Integer.parseInt(articleIdStr));
    }
}
