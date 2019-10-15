package com.phodal.pholedge.mapper;

import com.phodal.pholedge.book.model.Book;
import com.phodal.pholedge.book.model.BookRepresentaion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookMapper {

    void doSave(Book book);

    List<BookRepresentaion> list();

    Book byId(String id);
}
