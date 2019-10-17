package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.SaveBlogCommand;
import com.phodal.pholedge.blog.command.SavePlayCommand;
import com.phodal.pholedge.blog.model.Blog;
import com.phodal.pholedge.blog.repository.BlogRepository;
import com.phodal.pholedge.blog.repository.RemoteBlogRepository;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class BlogApplicationService {
    private BlogFactory blogFactory;

    private BlogRepository blogRepository;
    private RemoteBlogRepository remoteBlogRepository;

    public BlogApplicationService(BlogFactory blogFactory, BlogRepository blogRepository, RemoteBlogRepository remoteBlogRepository) {
        this.blogFactory = blogFactory;
        this.blogRepository = blogRepository;
        this.remoteBlogRepository = remoteBlogRepository;
    }

    String saveBlog(@Valid SaveBlogCommand command) {
        String content = remoteBlogRepository.getBlogByUrl(command.getUrl());
        Blog blog = blogFactory.create(command.getUrl(), command.getTitle(), content);
        blogRepository.save(blog);
        return blog.getId();
    }

    String savePlay(@Valid SavePlayCommand command) {
        remoteBlogRepository.getPlayById(command.getId());
        return "null";
    }
}
