package com.example.KafkaProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        // 1️⃣ Validation errors (@Valid DTO)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationException(
                MethodArgumentNotValidException ex) {

            String errorMessage = ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(", "));

            ErrorResponse errorResponse =
                    new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // 2️⃣ Illegal arguments
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
                IllegalArgumentException ex) {

            ErrorResponse errorResponse =
                    new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // 3️⃣ Kafka errors
        @ExceptionHandler(org.apache.kafka.common.KafkaException.class)
        public ResponseEntity<ErrorResponse> handleKafkaException(
                org.apache.kafka.common.KafkaException ex) {

            ErrorResponse errorResponse =
                    new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "Kafka error occurred: " + ex.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // 4️⃣ Generic exception (fallback)
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {

            ErrorResponse errorResponse =
                    new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "Something went wrong");

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
