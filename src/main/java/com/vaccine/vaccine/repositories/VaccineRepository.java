package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
    @Query(value = "SELECT * FROM `vaccine` WHERE vaccine = 'covid-19'", nativeQuery = true)
    List<Vaccine> findCovidVaccine();

    @Query(value = "SELECT * FROM `vaccine` WHERE vaccine != 'covid-19'", nativeQuery = true)
    List<Vaccine> findOtherVaccine();
}
