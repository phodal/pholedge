package com.phodal.pholedge.mapper;

import com.phodal.pholedge.book.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface BookMapper {
    @Insert("INSERT INTO book (id, isbn, name, createdAt) VALUES (#{id}, #{isbn}, #{name}, #{createdAt})")
    int doSave(Book book);
}
