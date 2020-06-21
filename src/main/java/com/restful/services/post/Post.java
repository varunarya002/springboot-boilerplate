package com.restful.services.post;

import java.util.Date;

public class Post {
    private Integer id;
    private Date createdAt = new Date();
    private String comment;

    public Post(Integer id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getComment() {
        return comment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", comment='" + comment + '\'' +
                '}';
    }
}
