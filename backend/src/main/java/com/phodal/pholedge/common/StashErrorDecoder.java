package com.phodal.pholedge.common;

import com.phodal.pholedge.core.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

import static feign.FeignException.errorStatus;

public class StashErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            return new NotFoundException("");
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new NotFoundException("");
        }
        return errorStatus(methodKey, response);
    }
}
