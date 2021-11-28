package com.wonderlogger.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WonderLoggerService {

    @Autowired
    WonderExceptionRepository wonderExceptionRepository;

    public String getExceptions(String pSoftware, String pVersion) {
        return new Gson().toJson(wonderExceptionRepository.findBySoftwareAndVersao(pSoftware, pVersion));
    }

    public String getExceptions(String pSoftware, String pVersion, String pClasse) {
        return new Gson().toJson(wonderExceptionRepository.findBySoftwareAndVersaoAndClasse(pSoftware, pVersion, pClasse));
    }

    public String saveWonderException(WonderException pWonderException) {
        wonderExceptionRepository.save(pWonderException);
        return "Salvo";
    }
}
