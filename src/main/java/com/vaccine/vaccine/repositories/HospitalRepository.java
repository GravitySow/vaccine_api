package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
