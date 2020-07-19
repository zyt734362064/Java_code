package view;

import model.Article;
import model.User;

import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-19
 */
public class HtmlGenerator {
    public static String getMessagePage(String message,String nextUrl){
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
        stringBuilder.append(String.format("<div><a href=\"%s\"> 点击这里进行跳转 </a></div>"
                ,nextUrl));
        stringBuilder.append("</body>");
        stringBuilder.append("<html>");
        return stringBuilder.toString();
    }
    //按照字符串拼装的方式
    public static String getArticleListPage(List<Article> articles, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3>欢迎您！"+ user.getName() + "</h3>");
        //有一个文章列表，显示每个文章的标题
        for (Article article:articles){
            stringBuilder.append(String.format("<div style=\"width: 200px;height: 20px\"><a  href=\"article?articleId=%d\"> %s </a></div>"
            ,article.getArticleId(),article.getTitle()));
        }
        stringBuilder.append("<hr>");
        stringBuilder.append(String.format("<div>当前共有博客 %d 篇</div>",articles.size()));

        stringBuilder.append("<div>发布文章</div>");
        stringBuilder.append("<div>");

        stringBuilder.append("<form menthod=\" post \" action=\"article\" >");
        stringBuilder.append("<input type=\"test\" name=\"title\" placeholder=\"请输入文章标题\">");
        stringBuilder.append("<br>");
        stringBuilder.append("<input type=\"submit\" values=\"发布文章\">");
        stringBuilder.append("</form>");
        stringBuilder.append("</div>");
        stringBuilder.append("</body>");
        stringBuilder.append("<html>");
        return stringBuilder.toString();
    }
    public static String getArticleDetailPage(Article article, User user, User author){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<haed>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        stringBuilder.append("a {" +
                "color:#333;" +
                "text-decoration:none;" +
                "width:200px;" +
                "height:50px;"+
                "}");
        stringBuilder.append("a:hover{" +
                "color:white;" +
                "background-color:orange;" +
                "}");
        stringBuilder.append("body{" +
                "background-repeat:none;" +
                "background-position:0 center;" +
                "}");
        stringBuilder.append("</style>");
        return stringBuilder.toString();
    }
}
