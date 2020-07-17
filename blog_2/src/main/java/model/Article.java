package model;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-17
 */
public class Article {
    private int arrticleId;
    private String title;
    private String content;
    private int userId;

    public int getArrticleId() {
        return arrticleId;
    }

    public void setArrticleId(int arrticleId) {
        this.arrticleId = arrticleId;
    }

    public String getTitle() {
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
