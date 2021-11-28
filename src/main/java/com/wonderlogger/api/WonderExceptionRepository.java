package com.wonderlogger.api;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WonderExceptionRepository extends CrudRepository<WonderException, Integer> {
    List<WonderException> findBySoftwareAndVersao(String software, String versao);

    List<WonderException> findBySoftwareAndVersaoAndClasse(String software, String versao, String classe);
}
