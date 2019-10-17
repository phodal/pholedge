package com.phodal.pholedge.blog.repository;

import com.phodal.pholedge.blog.model.WdsmPlay;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "blog",  url = "https://www.wandianshenme.com/")
public interface WdsmPlayClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/play/{playId}/")
    WdsmPlay getPlay(@PathVariable("playId") String playId);
}