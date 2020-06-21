package com.restful.services.user;

//import com.restful.services.post.Post;
import com.restful.services.post.PostNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.TypeReferences;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserResource {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDaoService service;

    @GetMapping("/hello")
    public String welcomeMessage() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }



    @GetMapping("users/{id}")
    public EntityModel retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id-"+id);
        }
        EntityModel<User> model = new EntityModel<>(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkTo.withRel("all-users"));

        return model;
    }

    @PostMapping("users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

//    @GetMapping("users/{id}")
//    public List<Post> retrieveUserPosts(@PathVariable int id) {
//        User user = service.findOne(id);
//        if (user == null) throw new UserNotFoundException("id-"+id);
//        return service.findAllUserPosts(user);
//    }
//
//    @GetMapping("users/{id}/posts/{postId}")
//    public Post retrievePost(@PathVariable int id, @PathVariable int postId) {
//        User user = service.findOne(id);
//        if (user == null) throw new UserNotFoundException("id-"+id);
//        Post post = service.findUserPost(postId, user);
//        if (post == null) throw new PostNotFoundException("id-"+id);
//        return post;
//    }
//
//    @PostMapping("users/{id}/posts")
//    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
//        User user = service.findOne(id);
//        if (user == null) throw new UserNotFoundException("id-"+id);
//        Post savedPost = service.savePost(post, user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedPost.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }
}
