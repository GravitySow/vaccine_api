package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineReserveRepository extends JpaRepository<VaccineReserve, Integer> {
    List<VaccineReserve> findByUserId(int userId);

//    List<VaccineReserve> findByHospitalId(int HospitalId);

    @Query(value = "SELECT * FROM `Vaccine_Reserve` v INNER JOIN `User` u ON v.user_id = u.id WHERE hospital_id = ?1", nativeQuery = true)
    List<VaccineReserveHopital> findByHospitalId(int HospitalId);
}
