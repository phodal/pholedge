package com.phodal.pholedge.mapper;

import com.phodal.pholedge.book.BookFactory;
import com.phodal.pholedge.book.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookMapperTest {
    @Autowired(required = true)
    private BookMapper bookMapper;

    @Test
    public void findByStateTest() {
        Book book = Book.create("123", "324", "#4");
        String bookId = book.getId();

        bookMapper.doSave(book);
        Book storedBook = bookMapper.byId(bookId);
        assertThat(storedBook.getIsbn()).isEqualTo("324");
    }
}