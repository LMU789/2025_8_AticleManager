package org.example.vo;

public class Article {

    private int id;
    private String title; // 제목
    private String body; // 내용
    private String regDate;
    private String updateDate;

    public Article(int id, String title, String body,String date) {
        this.id = id;
        this.regDate = date;
        this.updateDate = date;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String date) {
        this.regDate = date;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
