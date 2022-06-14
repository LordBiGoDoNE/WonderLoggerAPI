package com.wonderlogger.repository;

import com.wonderlogger.entity.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SoftwareRepository extends JpaRepository<Software, Long> {
    List<Software> findAll();

    @Query("select s from Software s where upper(s.software) = upper(?1)")
    Optional<Software> findBySoftwareIsAllIgnoreCase(String software);
}
