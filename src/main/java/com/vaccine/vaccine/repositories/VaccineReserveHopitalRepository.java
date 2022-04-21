package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineReserveHopitalRepository extends JpaRepository<VaccineReserveHopital, Integer> {
//    List<VaccineReserve> findByUserId(int userId);

    List<VaccineReserveHopital> findByHospitalIdOrderByDateAsc(int HospitalId);
}
