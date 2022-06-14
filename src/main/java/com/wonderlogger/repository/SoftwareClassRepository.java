package com.wonderlogger.repository;

import com.wonderlogger.entity.Software;
import com.wonderlogger.entity.SoftwareClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoftwareClassRepository extends JpaRepository<SoftwareClass, Long> {
    List<SoftwareClass> findAll();

    @Query("select s from SoftwareClass s where s.software = ?1 and upper(s.className) = upper(?2)")
    Optional<SoftwareClass> findBySoftwareAndClassNameIgnoreCase(Software software, String className);
}
