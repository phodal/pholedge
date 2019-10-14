package com.phodal.pholedge.common.exception;

import static com.google.common.collect.ImmutableMap.of;
import static com.phodal.pholedge.common.exception.BookErrorCode.BOOK_NOT_FOUND;

public class NotFoundException extends AppException {
    public NotFoundException(String orderId) {
        super(BOOK_NOT_FOUND, of("orderId", orderId));
    }
}

