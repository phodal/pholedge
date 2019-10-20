package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.SaveBlogCommand;
import com.phodal.pholedge.blog.command.SavePlayCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static com.google.common.collect.ImmutableSortedMap.of;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/remoteSave")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> remoteSaveBlog(@RequestBody @Valid SaveBlogCommand command) {
        return of("id", blogService.saveBlog(command));
    }

    @PostMapping("/savePlay")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> savePlay(@RequestBody @Valid SavePlayCommand command) {
        return of("id", blogService.savePlay(command));
    }
}
