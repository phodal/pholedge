package com.phodal.pholedge;

import com.phodal.pholedge.book.BookController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PholedgeApplicationTest {

	@Autowired
	private BookController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
