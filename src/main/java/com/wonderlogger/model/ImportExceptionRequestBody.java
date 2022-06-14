package com.wonderlogger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportExceptionRequestBody {
    private String software;

    private String version;

    private List<ImportRequestWonderException> wonderExceptions;
}