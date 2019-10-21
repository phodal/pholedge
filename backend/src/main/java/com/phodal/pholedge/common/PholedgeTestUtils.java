package com.phodal.pholedge.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PholedgeTestUtils {
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
