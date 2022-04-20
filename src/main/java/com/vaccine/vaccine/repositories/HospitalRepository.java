package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    @Query(value = "SELECT * FROM `hospital` where id > 0", nativeQuery = true)
    List<Hospital> findAllHospital();
}
