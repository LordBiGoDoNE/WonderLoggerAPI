package com.wonderlogger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportRequestWonderException {
    private long id;
    private String softwareClass;
    private Date dateHour;
    private String exceptionName;
    private String message;
    private String stacktrace;
}
