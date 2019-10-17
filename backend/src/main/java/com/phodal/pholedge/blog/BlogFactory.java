package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.model.Blog;
import com.phodal.pholedge.core.IdGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BlogFactory {
    private final IdGenerator idGenerator;

    public BlogFactory(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Blog create(String url, String response) {
        String id = idGenerator.generate();
        return Blog.create(id, url, response);
    }
}
