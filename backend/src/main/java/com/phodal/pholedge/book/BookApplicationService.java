package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import com.phodal.pholedge.book.model.command.CreateBookCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookApplicationService {
    private final BookFactory bookFactory;
    private final BookRepository bookRepository;

    public BookApplicationService(BookFactory bookFactory, BookRepository bookRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public String createBook(CreateBookCommand command) {
        Book book = bookFactory.create(command.getIsbn(), command.getName());
        bookRepository.save(book);
        return book.getId();
    }
}
