package com.kugelschlag.digitalocean.exceptions;

public class DigitalOceanException extends RuntimeException {

    public DigitalOceanException(String message) {
        super(message);
    }

    public DigitalOceanException(String message, Throwable cause) {
        super(message, cause);
    }
}
