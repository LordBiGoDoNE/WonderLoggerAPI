package com.wonderlogger.repository;

import com.wonderlogger.entity.ExceptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExceptionTypeRepository extends JpaRepository<ExceptionType, Long> {
    List<ExceptionType> findAll();

    Optional<ExceptionType> findByExceptionName(String exceptionName);
}
