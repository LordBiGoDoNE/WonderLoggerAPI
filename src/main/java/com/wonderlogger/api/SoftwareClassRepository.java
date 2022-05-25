package com.wonderlogger.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftwareClassRepository extends JpaRepository<SoftwareClass, Long> {
    SoftwareClass getById(long id);

    List<SoftwareClass> findAll();

    Optional<SoftwareClass> findByClassName(String className);
}
