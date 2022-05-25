package com.wonderlogger.model;

import com.wonderlogger.api.WonderException;

import java.util.List;

public class ImportExceptionRequestBody {
    private String software;
    private String version;
    private List<ImportRequestWonderException> wonderExceptions;

    public ImportExceptionRequestBody(String software, String version, List<ImportRequestWonderException> wonderExceptions) {
        this.software = software;
        this.version = version;
        this.wonderExceptions = wonderExceptions;
    }

    public String getSoftware() {
        return software;
    }

    public String getVersion() {
        return version;
    }

    public List<ImportRequestWonderException> getWonderExceptions() {
        return wonderExceptions;
    }
}