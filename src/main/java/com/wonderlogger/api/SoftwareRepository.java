package com.wonderlogger.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftwareRepository extends JpaRepository<Software, Long> {
    Software getById(long id);

    List<Software> findAll();

    Optional<Software> findBySoftwareIgnoreCase(String software);
}
