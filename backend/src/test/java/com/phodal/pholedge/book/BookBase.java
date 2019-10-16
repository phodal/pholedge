package com.phodal.pholedge.book;

import com.phodal.pholedge.book.model.Book;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookApplicationService.class)
public abstract class BookBase {

	@Autowired
	BookController bookController;

	@MockBean
    BookApplicationService bookApplicationService;

	@Before
    public void setup() {
		System.out.println("hello, world------------s");
		RestAssuredMockMvc.standaloneSetup(bookController);

		Mockito.when(bookApplicationService.getBookById("123"))
				.thenReturn(Book.create("123", "foo", "bee").toRepresentation());
	}

}
