package com.wonderlogger.service;

import com.google.gson.GsonBuilder;
import com.wonderlogger.entity.*;
import com.wonderlogger.model.GetExceptionsRequestBody;
import com.wonderlogger.model.ImportExceptionRequestBody;
import com.wonderlogger.model.ImportRequestWonderException;
import com.wonderlogger.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.LockModeType;
import java.util.*;

@RestController
@Service
public class WonderLoggerService {

    @Autowired
    SoftwareRepository softwareRepository;

    @Autowired
    SoftwareVersionRepository softwareVersionRepository;

    @Autowired
    WonderExceptionRepository wonderExceptionRepository;

    @Autowired
    SoftwareClassRepository softwareClassRepository;

    @Autowired
    ExceptionTypeRepository exceptionTypeRepository;

    private GsonBuilder gsonBuilder = new GsonBuilder();

    public String getSoftwareList() {
        return gsonBuilder.create().toJson(softwareRepository.findAll());
    }

    public String getVersionList(long pIdSoftware) {
        return gsonBuilder.create().toJson(softwareVersionRepository.findBySoftware_Id(pIdSoftware));
    }

    public String getExceptionsType(long idSoftware, long idSoftwareVersion) {
        return gsonBuilder.create().toJson(wonderExceptionRepository.getExceptionTypeByIdSoftwareAndIdVersion(idSoftware, idSoftwareVersion));
    }

    public String getSoftwareClasses(long idSoftware, long idSoftwareVersion) {
        return gsonBuilder.create().toJson(wonderExceptionRepository.getSoftwareClassByIdSoftwareAndIdVersion(idSoftware, idSoftwareVersion));
    }

    public String getWonderExceptions(GetExceptionsRequestBody getExceptionsRequestBody) {
        long idSoftware = getExceptionsRequestBody.idSoftware();
        long idVersion = getExceptionsRequestBody.idVersion();
        List<Long> idsSoftwareClass = getExceptionsRequestBody.idSoftwareClass();
        List<Long> idsExceptionType = getExceptionsRequestBody.idExceptionType();

        Date dataInicial = null;
        Date dataFinal = null;

        if (getExceptionsRequestBody.dataInicioTime() > 0) {
            dataInicial = new Date(getExceptionsRequestBody.dataInicioTime());
        }

        if (getExceptionsRequestBody.dataFimTime() > 0) {
            dataFinal = new Date(getExceptionsRequestBody.dataFimTime());
        }

        return gsonBuilder.setDateFormat("dd/MM/yyyy hh:mm:ss").create().toJson(
                wonderExceptionRepository.getWonderExceptions(idSoftware, idVersion, idsSoftwareClass, idsExceptionType, dataInicial, dataFinal));
    }

    public String saveWonderException(ImportExceptionRequestBody pImportExceptionRequestBody) {
        List<WonderException> wonderExceptionList = new ArrayList<>();

        Software software = getSoftwareToImport(pImportExceptionRequestBody.getSoftware());

        SoftwareVersion softwareVersion = getSoftwareVersionToImport(software, pImportExceptionRequestBody.getVersion());

        for (ImportRequestWonderException importRequestWonderException : pImportExceptionRequestBody.getWonderExceptions()) {
            SoftwareClass softwareClass = getSoftwareClassToImport(software, importRequestWonderException.getSoftwareClass());

            ExceptionType exceptionType = getExceptionTypeToImport(importRequestWonderException.getExceptionName());

            wonderExceptionList.add(new WonderException(software,
                    softwareVersion,
                    softwareClass,
                    exceptionType,
                    importRequestWonderException.getDateHour(),
                    importRequestWonderException.getMessage(),
                    importRequestWonderException.getStacktrace()));
        }

        wonderExceptionRepository.saveAll(wonderExceptionList);

        return "Importação dos logs efetuado com sucesso!";
    }


    private Software getSoftwareToImport(String pSoftware) {
        Optional<Software> software = softwareRepository.findBySoftwareIsAllIgnoreCase(pSoftware);

        if (!software.isPresent()) {
            software = Optional.of(softwareRepository.saveAndFlush(new Software(pSoftware)));
        }

        return software.get();
    }

    private SoftwareVersion getSoftwareVersionToImport(Software pSoftware, String pVersion) {
        Optional<SoftwareVersion> softwareVersion = softwareVersionRepository.findBySoftwareAndVersion(pSoftware, pVersion);

        if (!softwareVersion.isPresent()) {
            softwareVersion = Optional.of(softwareVersionRepository.saveAndFlush(new SoftwareVersion(pSoftware, pVersion)));
        }

        return softwareVersion.get();
    }

    private SoftwareClass getSoftwareClassToImport(Software pSoftware, String pSoftwareClass) {
        Optional<SoftwareClass> softwareClass = softwareClassRepository.findBySoftwareAndClassNameIgnoreCase(pSoftware, pSoftwareClass);

        if (!softwareClass.isPresent()) {
            softwareClass = Optional.of(softwareClassRepository.saveAndFlush(new SoftwareClass(pSoftware, pSoftwareClass)));
        }

        return softwareClass.get();
    }

    private ExceptionType getExceptionTypeToImport(String pExceptionName) {
        Optional<ExceptionType> exceptionType = exceptionTypeRepository.findByExceptionName(pExceptionName);

        if (!exceptionType.isPresent()) {
            exceptionType = Optional.of(exceptionTypeRepository.saveAndFlush(new ExceptionType(pExceptionName)));
        }

        return exceptionType.get();
    }
}
