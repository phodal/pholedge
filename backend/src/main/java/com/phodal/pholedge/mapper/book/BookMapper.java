package com.phodal.pholedge.mapper.book;

import com.phodal.pholedge.book.model.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookMapper {
    int save(Book book);
}
