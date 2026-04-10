package com.hexaware.employee.dto;

public class ErrorMessage {
    public String message;
    public ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}