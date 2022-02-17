package com.wangpeng.pojo;

public class Article {
    /**
     * 文章id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 发起人
     */
    private String people;
    /**
     * 日期
     */
    private String date;
    /**
     * 地址
     */
    private String url;

    public Article() {
    }

    public Article(Integer id, String title, String people, String date, String url) {
        this.id = id;
        this.title = title;
        this.people = people;
        this.date = date;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", people='" + people + '\'' +
                ", date='" + date + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
