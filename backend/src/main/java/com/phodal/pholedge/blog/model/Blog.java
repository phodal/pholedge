package com.phodal.pholedge.blog.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

import static java.time.Instant.now;

@Getter
@Builder
public class Blog {
    private String id;
    private String url;
    private String title;
    private String content;
    private Instant indexedAt;

    public static Blog create(String id, String url, String title, String response) {
        return Blog.builder()
                .id(id)
                .url(url)
                .title(title)
                .content(response)
                .indexedAt(now())
                .build();
    }
}
