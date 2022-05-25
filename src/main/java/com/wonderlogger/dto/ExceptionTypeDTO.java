package com.wonderlogger.dto;

import javax.persistence.*;

public class ExceptionTypeDTO {

    private long id;
    private String exceptionName;

    public ExceptionTypeDTO(long id, String exceptionName) {
        this.id = id;
        this.exceptionName = exceptionName;
    }

    public ExceptionTypeDTO(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public ExceptionTypeDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
}
