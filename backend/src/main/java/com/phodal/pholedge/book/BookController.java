package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.BookRepresentaion;
import com.phodal.pholedge.book.model.command.CreateBookCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableSortedMap.of;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookApplicationService applicationService;

    public BookController(BookApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> createBook(@RequestBody @Valid CreateBookCommand command) {
        return of("id", applicationService.createBook(command));
    }

    @GetMapping("/")
    public List<BookRepresentaion> getBookList() {
        BookRepresentaion bookRepresentaion = new BookRepresentaion("123", "name");
        List<BookRepresentaion> bookList = new ArrayList<BookRepresentaion>();
        bookList.add(bookRepresentaion);
        return bookList;
    }
}
