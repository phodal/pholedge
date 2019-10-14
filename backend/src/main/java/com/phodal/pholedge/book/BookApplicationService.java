package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import com.phodal.pholedge.book.model.command.CreateBookCommand;
import org.springframework.stereotype.Component;

@Component
public class BookApplicationService {
    private final BookFactory bookFactory;

    public BookApplicationService(BookFactory bookFactory) {
        this.bookFactory = bookFactory;
    }

    public String createBook(CreateBookCommand command) {
        Book book = bookFactory.create(command.getIsbn(), command.getName());
        return book.getId();
    }
}
