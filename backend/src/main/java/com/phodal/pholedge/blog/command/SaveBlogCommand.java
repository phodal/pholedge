package com.phodal.pholedge.blog.command;

import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Value
public class SaveBlogCommand {
    @Valid
    @NotNull(message = "不能为空")
    private String url;

    private String title;
}
