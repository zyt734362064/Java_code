package model;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-13
 */
public class Article {
    private int articleId;
    private String title;
    private String content;
    private int userId;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
