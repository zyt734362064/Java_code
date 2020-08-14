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
        stringBuilder.append("<title>文章列表页面</title>");
        stringBuilder.append("<style>");
        stringBuilder.append(".article {" +
                "color: #333; " +
                "test-decoration:none;" +
                "width:200px;" +
                "height: 50px;" +
                "}");
        stringBuilder.append(".article:hover {" +
                " color: white;" +
                "background-color:#044ff7;" +
                "}");
        stringBuilder.append("body {" +
                "background-repeat:none;" +
                "background-position: 0 center;" +
                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3>欢迎你！" + user.getName() + "</h3>");
        stringBuilder.append("<hr>");
        for (Article article : articles){
            stringBuilder.append(String.format("<div style=\"width: 200px;height: 50px; line-height: 50px;\"><a class=\"article\" "+
                    "href=\"article?articleId=%d\"> %s</a>" + "<a href=\"deleteArticle?articleId=%d\">删除</a></div>",
                    article.getArticleId(), article.getTitle(),article.getArticleId()));
        }
            stringBuilder.append("<hr>");
            stringBuilder.append(String.format("<div>当前共有博客 %d 篇</div>",articles.size()));

            stringBuilder.append("<div>发表文章</div>");
            stringBuilder.append("<div>");
            stringBuilder.append("<form method=\"post\" action=\"article\">");
            stringBuilder.append("<input type=\"text\" style\"width: 500px;margin-botton: 5px\" name=\"title\"placeholder=\"请输入标题\">");
            stringBuilder.append("<br>");
            stringBuilder.append("<textarea name=\"content\" style=\"width: 500px;height: 300px;\"></textarea>");
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
                "background-color: blue;" +
                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3>欢迎您！" + user.getName() +"</h3>");
        stringBuilder.append("<hr>");
        stringBuilder.append(String.format("<h1>%s</h1>",article.getTitle()));
        stringBuilder.append(String.format("<h4>作者： %s</h4>",author.getName()));
        stringBuilder.append(String.format("<div>%s<div>",article.getContent().replace("/n","<br>")));
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
