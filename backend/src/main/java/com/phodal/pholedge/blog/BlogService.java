package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.SaveBlogCommand;
import com.phodal.pholedge.blog.command.SavePlayCommand;
import com.phodal.pholedge.blog.model.Blog;
import com.phodal.pholedge.blog.model.WdsmPlay;
import com.phodal.pholedge.blog.repository.BlogRepository;
import com.phodal.pholedge.blog.repository.RemoteBlogRepository;
import com.phodal.pholedge.core.domain.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Component
public class BlogService implements Service {
    private BlogFactory blogFactory;

    private BlogRepository blogRepository;
    private RemoteBlogRepository remoteBlogRepository;

    public BlogService(BlogFactory blogFactory, BlogRepository blogRepository, RemoteBlogRepository remoteBlogRepository) {
        this.blogFactory = blogFactory;
        this.blogRepository = blogRepository;
        this.remoteBlogRepository = remoteBlogRepository;
    }

    @Transactional
    String saveBlog(@Valid SaveBlogCommand command) {
        String content = remoteBlogRepository.getBlogByUrl(command.getUrl());
        Blog blog = blogFactory.create(command.getUrl(), command.getTitle(), content);
        blogRepository.save(blog);
        return blog.getId();
    }

    @Transactional
    String savePlay(@Valid SavePlayCommand command) {
        WdsmPlay play = remoteBlogRepository.getPlayById(command.getId());
        Blog blog = blogFactory.create(play.getSlug(), play.getTitle(), play.getContent());
        blogRepository.save(blog);
        return blog.getId();
    }
}
