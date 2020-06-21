package com.restful.services.user;

//import com.restful.services.post.Post;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private Integer id;

    @Size(min=2)
    private String name;

    @Past
    private Date birthDate;

//    private static List<Post> posts = new ArrayList<>();

    public User() {

    }

//    public void setPost(Post post) {
//        this.posts.add(post);
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
