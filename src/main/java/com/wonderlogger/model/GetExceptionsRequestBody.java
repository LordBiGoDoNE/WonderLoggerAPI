package com.wonderlogger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetExceptionsRequestBody {
    @JsonProperty("software")
    private long idSoftware;
    @JsonProperty("version")
    private long idVersion;
    @JsonProperty("exception")
    private List<Long> idExceptionType;
    @JsonProperty("classe")
    private List<Long> idSoftwareClass;
    @JsonProperty("data_inicio")
    private long dataInicioTime;
    @JsonProperty("data_fim")
    private long dataFimTime;

    public GetExceptionsRequestBody(long idSoftware, long idVersion, List<Long> idExceptionType, List<Long> idSoftwareClass, long dataInicioTime, long dataFimTime) {
        this.idSoftware = idSoftware;
        this.idVersion = idVersion;
        this.idExceptionType = idExceptionType;
        this.idSoftwareClass = idSoftwareClass;
        this.dataInicioTime = dataInicioTime;
        this.dataFimTime = dataFimTime;
    }

    public long getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(long idSoftware) {
        this.idSoftware = idSoftware;
    }

    public long getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(long idVersion) {
        this.idVersion = idVersion;
    }

    public List<Long> getIdExceptionType() {
        return idExceptionType;
    }

    public void setIdExceptionType(List<Long> idExceptionType) {
        this.idExceptionType = idExceptionType;
    }

    public List<Long> getIdSoftwareClass() {
        return idSoftwareClass;
    }

    public void setIdSoftwareClass(List<Long> idSoftwareClass) {
        this.idSoftwareClass = idSoftwareClass;
    }

    public long getDataInicioTime() {
        return dataInicioTime;
    }

    public void setDataInicioTime(long dataInicioTime) {
        this.dataInicioTime = dataInicioTime;
    }

    public long getDataFimTime() {
        return dataFimTime;
    }

    public void setDataFimTime(long dataFimTime) {
        this.dataFimTime = dataFimTime;
    }
}