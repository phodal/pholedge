package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.BookRepresentaion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @GetMapping("/")
    public List<BookRepresentaion> getBookList() {
        BookRepresentaion bookRepresentaion = new BookRepresentaion("123", "name");
        List<BookRepresentaion> bookList = new ArrayList<BookRepresentaion>();
        bookList.add(bookRepresentaion);
        return bookList;
    }
}
