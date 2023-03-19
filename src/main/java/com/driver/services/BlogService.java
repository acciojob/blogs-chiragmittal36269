package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);

        User user = userRepository1.findById(userId).get();

        blog.setUser(user);

//        List<Blog> b = new ArrayList<>();
//        b.add(blog);
//        user.setBlogList(b);
//        userRepository1.save(user);

        blogRepository1.save(blog);
        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images

//        Blog blog = blogRepository1.findById(blogId).get();
//        blog.setImageList(new ArrayList<>());
//
//        User user = userRepository1.findById(blog.getUser().getId()).get();
//        List<Blog> b = user.getBlogList();
//        b.remove(blog);

        blogRepository1.deleteById(blogId);

    }
}
