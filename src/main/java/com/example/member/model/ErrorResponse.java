package com.example.member.model;

import java.time.LocalDate;
import java.util.List;

public class ErrorResponse {
    private LocalDate timestamp;
    private Integer status;
    private List<String> errors;

    public ErrorResponse(List<String> errors, int status) {
        this.timestamp = LocalDate.now();
        this.status = status;
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
