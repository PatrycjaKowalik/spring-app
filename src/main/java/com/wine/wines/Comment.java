package com.wine.wines;

import javax.persistence.*;

@Entity
@Table(name = "com")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String author;

    @Column
    private String wineN;

    @Column
    private String commentN;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWineN() {
        return wineN;
    }

    public void setWineN(String wineN) {
        this.wineN = wineN;
    }

    public String getCommentN() {
        return commentN;
    }

    public void setCommentN(String commentN) {
        this.commentN = commentN;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", wineN='" + wineN + '\'' +
                ", commentN='" + commentN + '\'' +
                '}';
    }
}
