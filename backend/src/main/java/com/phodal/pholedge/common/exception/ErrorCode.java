package com.phodal.pholedge.common.exception;

public interface ErrorCode {
    int getStatus();

    String getMessage();

    String getCode();
}

