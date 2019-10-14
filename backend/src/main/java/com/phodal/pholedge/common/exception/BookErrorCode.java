package com.phodal.pholedge.common.exception;

public enum BookErrorCode implements ErrorCode {
    BOOK_CANNOT_BE_MODIFIED(409, "书引无法变更"),
    BOOK_NOT_FOUND(404, "没有找到书引");

    private int status;
    private String message;

    BookErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}

