package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

}
