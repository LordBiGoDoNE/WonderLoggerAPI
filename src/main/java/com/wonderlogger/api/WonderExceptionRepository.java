package com.wonderlogger.api;

import com.wonderlogger.dto.WonderExceptionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface WonderExceptionRepository extends JpaRepository<WonderException, Long>, WonderExceptionRepositoryCustom {
    @Query("SELECT DISTINCT NEW com.wonderlogger.api.ExceptionType(" +
            " et.id, et.exceptionName)" +
            " FROM WonderException wonder" +
            " JOIN wonder.exceptionType et" +
            " WHERE wonder.software.id = :idSoftware" +
            " AND wonder.softwareVersion.id = :idVersion")
    List<ExceptionType> getExceptionTypeByIdSoftwareAndIdVersion(@Param("idSoftware") long idSoftware, @Param("idVersion") long idVersion);

    @Query("SELECT DISTINCT NEW com.wonderlogger.api.SoftwareClass(sc.id, sc.software, sc.className) FROM WonderException wonder JOIN wonder.softwareClass sc WHERE wonder.software.id = :idSoftware AND wonder.softwareVersion.id = :idVersion")
    List<SoftwareClass> getSoftwareClassByIdSoftwareAndIdVersion(@Param("idSoftware") long idSoftware, @Param("idVersion") long idVersion);
}
