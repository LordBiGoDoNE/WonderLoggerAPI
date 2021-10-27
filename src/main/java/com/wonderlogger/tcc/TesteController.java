package com.wonderlogger.tcc;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @Autowired
    WonderExceptionRepository wonderExceptionRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String Get() {
        return new Gson().toJson(wonderExceptionRepository.findAll());
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public String createPerson(@RequestBody WonderException wE) {
        wonderExceptionRepository.save(wE);
        return "Salvo";
    }
}
