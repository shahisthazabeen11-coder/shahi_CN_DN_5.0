package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging_Error {
    private static final Logger logger = LoggerFactory.getLogger(Logging_Error.class);

    public static void main(String[] args) {

        logger.error("This is an error message");
        logger.warn("This is a warning message");

    }
}    