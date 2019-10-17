package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.model.Blog;
import com.phodal.pholedge.core.IdGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
public class BlogFactory {
    private final IdGenerator idGenerator;

    public BlogFactory(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Blog create(@Valid @NotNull(message = "不能为空") String url, String title, String response) {
        String id = idGenerator.generate();
        return Blog.create(id, url, title, response);
    }
}
