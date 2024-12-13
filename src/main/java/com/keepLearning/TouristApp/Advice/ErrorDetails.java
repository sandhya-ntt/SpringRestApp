package com.keepLearning.TouristApp.Advice;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {

    private String status;
    private String message;
    private LocalDateTime datetime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public ErrorDetails(String status, String message, LocalDateTime datetime) {
        this.status = status;
        this.message = message;
        this.datetime = datetime;
    }
}
