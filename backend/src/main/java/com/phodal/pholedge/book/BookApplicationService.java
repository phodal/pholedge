package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.command.CreateBookCommand;
import org.springframework.stereotype.Component;

@Component
public class BookApplicationService {

    public String createBook(CreateBookCommand command) {
        return "create";
    }
}
