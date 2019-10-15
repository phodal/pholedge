package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(BookRepository.class)
class BookRepositoryTest {
    @Autowired(required = true)
    private BookRepository bookRepository;

    @Test
    @Ignore
    public void should_get_save_data() {
        Book book = Book.create("123", "324", "#4");
        String bookId = book.getId();

        bookRepository.save(book);
        Book queryBook = bookRepository.byId(bookId);

        assertThat(queryBook.getId()).isEqualTo(book.getId());
    }
}