package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import com.phodal.pholedge.mapper.book.BookMapper;
import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    private final BookMapper bookMapper;

    public BookRepository(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public void save(Book book) {
        this.bookMapper.save(book);
    }
}
