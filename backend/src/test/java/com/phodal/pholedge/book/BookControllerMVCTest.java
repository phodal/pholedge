package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
@AutoConfigureMybatis
class BookControllerMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService applicationService;

    @Test
    public void should_return_default_data() throws Exception {
        Book book = Book.create("123", "324", "#4");
        given(applicationService.getBookById(anyString())).willReturn(book.toRepresentation());

        this.mockMvc.perform(get("/books/123"))
                .andExpect(status().isOk());
    }
}