package com.phodal.pholedge.mapper;

import com.phodal.pholedge.blog.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BlogMapper {
    void doSave(Blog blog);
}
