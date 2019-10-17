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
    private String description;
    private String content;
    private String indexedAt;
    private Instant createdAt;

    public static Blog create(String id, String url, String response) {
        return Blog.builder()
                .id(id)
                .url(url)
                .content(response)
                .createdAt(now())
                .build();
    }
}
