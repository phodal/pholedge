package com.phodal.pholedge.blog;

import com.phodal.pholedge.blog.command.SaveBlogCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static com.google.common.collect.ImmutableSortedMap.of;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {
    private final BlogApplicationService applicationService;

    public BlogController(BlogApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/remoteSave")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> remoteSaveBlog(@RequestBody @Valid SaveBlogCommand command) {
        return of("id", applicationService.saveBlog(command));
    }
}
