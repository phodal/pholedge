package com.phodal.pholedge.core.exception;

public interface ErrorCode {
    int getStatus();

    String getMessage();

    String getCode();
}

