package com.ecommerce.commonpackage.utils.results;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ExceptionResult<T> {
    private LocalDateTime timestamp;
    private String type;
    private T message;

    public ExceptionResult(String type, T message) {
        timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }
}