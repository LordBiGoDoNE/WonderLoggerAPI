package com.wonderlogger.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftwareVersionRepository extends JpaRepository<SoftwareVersion, Long> {
    SoftwareVersion getById(long id);

    List<SoftwareVersion> findBySoftware_Id(long id);

    Optional<SoftwareVersion> findByVersionIgnoreCase(String version);

    List<SoftwareVersion> findAll();
}
