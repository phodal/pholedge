package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.RemoteSaveBlogCommand;
import com.phodal.pholedge.blog.model.Blog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlogApplicationService {
    private RestTemplate restTemplate;

    private BlogFactory blogFactory;

    public BlogApplicationService(BlogFactory blogFactory) {
        this.blogFactory = blogFactory;
        this.restTemplate = new RestTemplate();
    }

    public String saveBlog(RemoteSaveBlogCommand command) {
        ResponseEntity<String> response = restTemplate.getForEntity("", String.class);
        Blog blog = blogFactory.create("", response.getBody());
        return blog.getId();
    }
}
