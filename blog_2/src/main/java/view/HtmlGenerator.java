package view;

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
}
