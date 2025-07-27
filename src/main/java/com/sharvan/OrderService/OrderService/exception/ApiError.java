package com.sharvan.OrderService.OrderService.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class ApiError {
    private String message;
    private HttpStatus httpStatus;
    private Instant timeStamp;

    public ApiError() {
        this.timeStamp = Instant.now();
    }

    public ApiError(String message, HttpStatus httpStatus) {
        this();
        this.message = message;
        this.httpStatus = httpStatus;

    }
}
