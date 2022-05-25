package com.wonderlogger.model;

import java.util.Date;

public class ImportRequestWonderException {

    private long id;
    private String softwareClass;
    private Date dateHour;
    private String exceptionName;
    private String message;
    private String stacktrace;

    public ImportRequestWonderException(String softwareClass, Date dateHour, String exceptionName, String message, String stacktrace) {
        this.softwareClass = softwareClass;
        this.dateHour = dateHour;
        this.exceptionName = exceptionName;
        this.message = message;
        this.stacktrace = stacktrace;
    }

    public ImportRequestWonderException() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSoftwareClass() {
        return softwareClass;
    }

    public void setSoftwareClass(String softwareClass) {
        this.softwareClass = softwareClass;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
        this.dateHour = dateHour;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }
}
