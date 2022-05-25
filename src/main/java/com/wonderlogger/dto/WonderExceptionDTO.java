package com.wonderlogger.dto;

import java.util.Date;

public class WonderExceptionDTO {

    private long id;
    private String exceptionName;
    private String className;
    private Date dataHora;
    private String stackTrace;

    public WonderExceptionDTO(long id, String exceptionName, String className, Date dataHora, String stackTrace) {
        this.id = id;
        this.exceptionName = exceptionName;
        this.className = className;
        this.dataHora = dataHora;
        this.stackTrace = stackTrace;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
