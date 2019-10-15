package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookFactory bookFactory;

    @Test
    public void should_get_save_data() {
        Book book = bookFactory.create("isbn", "name");
        String bookId = book.getId();

        bookRepository.save(book);
        Book queryBook = bookRepository.byId(bookId);

        assertThat(queryBook.getId()).isEqualTo(book.getId());
    }
}