package com.phodal.pholedge.book.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void should_convert_to_presentation() {
        Book afsBook = Book.create("123", "23424", "afs");
        BookRepresentaion bookRepresentaion = afsBook.toRepresentation();
        assertEquals(bookRepresentaion.getId(), afsBook.getId());
        assertEquals(bookRepresentaion.getName(), afsBook.getName());
    }

    @Test
    void should_save_book() {
        Book afsBook = Book.create("123", "23424", "afs");
        afsBook.save("phodal", "name");
        assertEquals(afsBook.getIsbn(), "phodal");
        assertEquals(afsBook.getName(), "name");
    }
}