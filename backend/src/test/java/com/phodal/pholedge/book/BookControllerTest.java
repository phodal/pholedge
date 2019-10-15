package com.phodal.pholedge.book;

import com.phodal.pholedge.BaseApiTest;
import org.junit.jupiter.api.Test;

class BookControllerTest extends BaseApiTest {
    @Test
    public void should_verify_api_exists() {
        given()
                .when()
                .get("/books/")
                .then()
                .statusCode(200);
    }
}