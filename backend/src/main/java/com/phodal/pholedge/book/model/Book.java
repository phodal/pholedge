package com.phodal.pholedge.book.model;

import com.phodal.pholedge.common.IdGenerator;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import static java.time.Instant.now;

@Getter
@Builder
public class Book {
    private String id;
    private String isbn;
    private String name;
    private Instant createdAt;

    public static Book create(String id, String isbn, String name) {
        return Book.builder()
                .id(id)
                .isbn(isbn)
                .name(name)
                .createdAt(now())

                .build();

    }
}
