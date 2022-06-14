package com.wonderlogger.repository;

import com.wonderlogger.entity.Software;
import com.wonderlogger.entity.SoftwareVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftwareVersionRepository extends JpaRepository<SoftwareVersion, Long> {
    List<SoftwareVersion> findBySoftware_Id(long id);

    Optional<SoftwareVersion> findBySoftwareAndVersion(Software software, String version);

    List<SoftwareVersion> findAll();
}
