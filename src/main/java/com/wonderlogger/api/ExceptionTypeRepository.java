package com.wonderlogger.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExceptionTypeRepository extends JpaRepository<ExceptionType, Long> {
    ExceptionType getById(long id);

    List<ExceptionType> findAll();

    Optional<ExceptionType> findByExceptionName(String exceptionName);
}
