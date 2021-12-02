package com.wonderlogger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WonderLoggerController {

    @Autowired
    WonderLoggerService wonderLoggerService;

    @RequestMapping(value = "/get/{software}/{versao}", method = RequestMethod.GET)
    public String Get(
            @PathVariable("software") String software,
            @PathVariable("versao") String versao) {
        return wonderLoggerService.getExceptions(software, versao);
    }

    @RequestMapping(value = "/get/{software}/{versao}/{classe}", method = RequestMethod.GET)
    public String Get(
            @PathVariable("software") String software,
            @PathVariable("versao") String versao,
            @PathVariable("classe") String classe) {
        return wonderLoggerService.getExceptions(software, versao, classe);
    }

    @PostMapping(value = "/importException", consumes = "application/json")
    public String criarWonderException(@RequestBody WonderException wE) {
        return wonderLoggerService.saveWonderException(wE);
    }
}
