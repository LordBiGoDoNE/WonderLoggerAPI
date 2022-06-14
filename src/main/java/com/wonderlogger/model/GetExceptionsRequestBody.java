package com.wonderlogger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true, chain = true)
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
}