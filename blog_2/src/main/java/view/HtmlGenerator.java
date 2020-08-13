package view;

import model.Article;
import model.User;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:提示跳转页面
 * 通过字符串拼接的形式，构造出一个 HTML 格式的内容来
 * User:Zyt
 * Date:2020-07-22
 */
public class HtmlGenerator {
    //提示跳转页面
    public static String getMessagePage(String message,String nextUrl) {


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");
        stringBuilder.append(String.format("<a href=\"%s\"> 点击这里进行跳转 </a>",nextUrl));
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleListPage(List<Article> articles, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面");
        stringBuilder.append("<style>");
        stringBuilder.append(".article {" +
                "color: #333; " +
                "test-decoration:none;" +
                "width:200px;" +
                "height: 50px;" +
                "}");
        stringBuilder.append(".artice:hover {" +
                " color: white;" +
                "backgroud-color:orange;" +
                "}");
        stringBuilder.append("body {" +
                "backgroud-repeat:none;" +
                "backgroud-position: 0 center;" +
                "}");
        stringBuilder.append("<style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<html>");
        stringBuilder.append("<h3>欢迎你！" + user.getName() + "</h3>");
        stringBuilder.append("<hr>");
        for (Article article : articles){
            stringBuilder.append(String.format("<div stryle=\"width: 200px;heighr: 50px; line-height: 50px\"><a class=\"article\" " +
                    "herf=\"article?articlId=%d\"> %s</a>)" + "<a href=\"deleteArticle?articleId\">删除</a></div>",article.getArticleId(),
                    article.getTitle(),article.getArticleId()));
        }
            stringBuilder.append("<hr>");
            stringBuilder.append(String.format("<div>当前共有博客 %d 篇</div>",articles.size()));

            stringBuilder.append("<div>发表文章</div>");
            stringBuilder.append("<div>");
            stringBuilder.append("<form method=\"post\" action=\"article\">");
            stringBuilder.append("<input type=\"test\" style\"width: 50px;height: 300px;\"></textarea>");
            stringBuilder.append("<br>");
            stringBuilder.append("<textarea nanme=\"content\" style=\"width: 50px;heigh: 300px;\"></textarea>");
            stringBuilder.append("<br>");
            stringBuilder.append("<input type=\"submit\" value\"发布文章\">");
            stringBuilder.append("</from>");
            stringBuilder.append("</div>");
            stringBuilder.append("</body>");
            stringBuilder.append("</html>");
            return stringBuilder.toString();
    }

    public static String getArticleDetailPage(Article article, User user, User author) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        stringBuilder.append("a {" +
                "color: #333;" +
                "text-decoration: none;" +
                "display: inline-block;" +
                "width: 200px;" +
                "height: 50px;" +
                "}");
        stringBuilder.append("a:hover {" +
                "color: white;" +
                "background-color: orange;" +
                "}");
        stringBuilder.append("<html>");
        stringBuilder.append("<html>");
        stringBuilder.append("<html>");

        return stringBuilder.toString();
    }
}
