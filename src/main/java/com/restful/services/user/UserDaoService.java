package com.restful.services.user;

//import com.restful.services.post.Post;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();
    private static int userCounter = 5;
    private static int postCounter = 0;

    static {
        users.add(new User(1, "Varun", new Date()));
        users.add(new User(2, "John", new Date()));
        users.add(new User(3, "Don", new Date()));
        users.add(new User(4, "Saurabh", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(userCounter++);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

//    public Post savePost(Post post, User user) {
//        if (post.getId() == null) {
//            post.setId(postCounter++);
//        }
//        user.setPost(post);
//        return post;
//    }
//
//    public Post findUserPost(int id, User user) {
//        List<Post> posts= user.getPosts();
//        for (Post post:posts) {
//            if (post.getId() == id) {
//                return post;
//            }
//        }
//        return null;
//    }
//
//    public List<Post> findAllUserPosts(User user) {
//        return user.getPosts();
//    }
}
