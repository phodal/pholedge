package com.phodal.pholedge.core;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    public String generate() {
        return UuidGenerator.newUuid();
    }
}
