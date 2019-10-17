package com.phodal.pholedge.blog.command;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
public class RemoteSaveBlogCommand {
//    @Pattern(regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "链接不是有效的 URL")
    @NotNull
    private String url;
}
