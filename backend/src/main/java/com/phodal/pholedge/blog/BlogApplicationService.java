package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.SaveBlogCommand;
import com.phodal.pholedge.blog.model.Blog;
import com.sun.research.ws.wadl.HTTPMethods;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;

@Component
public class BlogApplicationService {
    private RestTemplate restTemplate;

    private BlogFactory blogFactory;

    private BlogRepository blogRepository;

    public BlogApplicationService(BlogFactory blogFactory, BlogRepository blogRepository) {
        this.blogFactory = blogFactory;
        this.blogRepository = blogRepository;
        this.restTemplate = new RestTemplate();
    }

    String saveBlog(@Valid SaveBlogCommand command) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange(command.getUrl(), HttpMethod.GET, entity, String.class);
        Blog blog = blogFactory.create(command.getUrl(), command.getTitle(), response.getBody());
        blogRepository.save(blog);
        return blog.getId();
    }
}
