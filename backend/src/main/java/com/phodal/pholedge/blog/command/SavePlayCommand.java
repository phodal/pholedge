package com.phodal.pholedge.blog.command;

import lombok.Getter;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Value
public class SavePlayCommand {
    @Valid
    @NotNull(message = "不能为空")
    private String id;

    private String url;
}
