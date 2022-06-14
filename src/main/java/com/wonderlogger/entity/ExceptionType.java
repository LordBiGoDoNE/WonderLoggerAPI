package com.wonderlogger.entity;

import javax.persistence.*;

@Entity
@Table(name = "exceptiontype", uniqueConstraints={@UniqueConstraint(columnNames = {"exceptionname"})})
public class ExceptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "exceptionname")
    private String exceptionName;

    public ExceptionType(long id, String exceptionName) {
        this.id = id;
        this.exceptionName = exceptionName;
    }

    public ExceptionType(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public ExceptionType() {
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
