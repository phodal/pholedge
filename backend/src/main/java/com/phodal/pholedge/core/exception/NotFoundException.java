package com.phodal.pholedge.core.exception;

import static com.google.common.collect.ImmutableMap.of;
import static com.phodal.pholedge.core.exception.BookErrorCode.BOOK_NOT_FOUND;

public class NotFoundException extends AppException {
    public NotFoundException(String bookId) {
        super(BOOK_NOT_FOUND, of("bookId", bookId));
    }
}

