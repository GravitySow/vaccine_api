package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import com.vaccine.vaccine.entities.VaccineReserveIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface VaccineReserveInRepository extends JpaRepository<VaccineReserveIn, Integer> {
}
