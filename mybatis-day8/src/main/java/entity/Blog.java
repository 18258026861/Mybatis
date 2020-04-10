package entity;

import java.util.Date;

/**
 * @author YZY
 * @date 2020/4/10 - 22:01
 */
public class Blog {
    private String id;
    private String title;
    private String author;
    //属性名和字段名不一致，可以开启自动驼峰命名规则mapUnderscoreToCamelCase,在mybatis配置中心setter标签开启
    private Date creatTime;
    private int views;

    public Blog() {
    }

    public Blog(String id, String title, String author, Date creatTime, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creatTime = creatTime;
        this.views = views;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", creatTime=" + creatTime +
                ", views=" + views +
                '}';
    }
}
