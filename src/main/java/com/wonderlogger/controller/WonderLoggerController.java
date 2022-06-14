package com.wonderlogger.controller;

import com.wonderlogger.model.GetExceptionsRequestBody;
import com.wonderlogger.model.ImportExceptionRequestBody;
import com.wonderlogger.service.WonderLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WonderLoggerController {

    @Autowired
    WonderLoggerService wonderLoggerService;

    @RequestMapping(value = "/getsoftware", method = RequestMethod.GET)
    public String getSoftwareList() {
        return wonderLoggerService.getSoftwareList();
    }

    @RequestMapping(value = "/getversion/{software}", method = RequestMethod.GET)
    public String getVersionList(
            @PathVariable("software") long software) {
        return wonderLoggerService.getVersionList(software);
    }

    @RequestMapping(value = "/getexceptionstype/{software}/{versao}", method = RequestMethod.GET)
    public String getExceptionsType(
            @PathVariable("software") long software,
            @PathVariable("versao") long versao) {
        return wonderLoggerService.getExceptionsType(software, versao);
    }

    @RequestMapping(value = "/getsoftwareclasses/{software}/{versao}", method = RequestMethod.GET)
    public String getSoftwareClasses(
            @PathVariable("software") long software,
            @PathVariable("versao") long versao) {
        return wonderLoggerService.getSoftwareClasses(software, versao);
    }

    @PostMapping(value = "/getwonderexceptions", consumes = "application/json")
    public String getExceptions(@RequestBody GetExceptionsRequestBody getExceptionsRequestBody) {
        return wonderLoggerService.getWonderExceptions(getExceptionsRequestBody);
    }

    @PostMapping(value = "/importexception", consumes = "application/json")
    public String criarWonderException(@RequestBody ImportExceptionRequestBody importExceptionRequestBody) {
        return wonderLoggerService.saveWonderException(importExceptionRequestBody);
    }
}
