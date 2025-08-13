package com.tatatrent.wms.ui.rest.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tatatrent.wms.ui.rest.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        logger.warn("Validation failed: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String rawField = error.getField(); // e.g., skuList[0].storerkey
            String key = extractFieldKey(rawField);
            String message = error.getDefaultMessage();
            errors.put(key, message);
        }

        ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST.value(), false, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.warn("Constraint violation: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String path = violation.getPropertyPath().toString(); // e.g., createItemMaster.skuList[0].storerkey
            String key = extractFieldKey(path);
            String message = violation.getMessage();
            errors.put(key, message);
        }

        ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST.value(), false, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ApiResponse> handleDBExceptions(SQLException ex) {
        logger.error("Database error: {}", ex.getMessage(), ex);
        ApiResponse response = new ApiResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                false,
                "A database error occurred. Please contact support."
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        logger.error("Unhandled exception: {}", ex.getMessage(), ex);
        ApiResponse response = new ApiResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                false,
                "An unexpected error occurred. Please try again later."
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String extractFieldKey(String rawField) {
        // Handles both MethodArgumentNotValid and ConstraintViolation paths
        String clean = rawField.replaceAll(".*\\.", "").replaceAll(".*\\[\\d+\\]\\.", "");
        return clean.toUpperCase();
    }
}