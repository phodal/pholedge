package com.phodal.pholedge.book.contract;


import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractRestTest {
    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.phodal", "pholedge", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void get_book_from_service_contract() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Book> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/books/1", Book.class);

        BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}