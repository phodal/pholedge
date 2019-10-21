package com.phodal.pholedge.blog.repository;

import com.phodal.pholedge.blog.model.WdsmPlay;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
public interface WdsmPlayClient {
    @RequestLine("GET /api/play/{playId}/")
    WdsmPlay getPlay(@Param("playId") String playId);
}