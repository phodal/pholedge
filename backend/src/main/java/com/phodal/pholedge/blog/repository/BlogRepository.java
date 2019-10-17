package com.phodal.pholedge.blog.repository;

import com.phodal.pholedge.blog.model.Blog;
import com.phodal.pholedge.core.domain.Repository;
import com.phodal.pholedge.mapper.BlogMapper;
import org.springframework.stereotype.Component;

@Component
public class BlogRepository  implements Repository {
    private final BlogMapper blogMapper;

    public BlogRepository(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    public void save(Blog blog) {
        this.blogMapper.doSave(blog);
    }
}
