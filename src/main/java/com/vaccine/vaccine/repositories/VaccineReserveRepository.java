package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface VaccineReserveRepository extends JpaRepository<VaccineReserve, Integer> {
    List<VaccineReserve> findByUserId(int userId);

//    List<VaccineReserve> findByHospitalId(int HospitalId);

    @Query(value = "SELECT * FROM `vaccine_reserve` v INNER JOIN `user` u ON v.user_id = u.id WHERE hospital_id = ?1", nativeQuery = true)
    List<VaccineReserveHopital> findByHospitalId(int HospitalId);

//    @Modifying
//    @Query(value = "insert into vaccine_reserve (`id, `user_id`, `vaccine_id`, `hospital_id`, `vaccine_count`, `date`, `status`, `create_date`, `update_date`) VALUES (NULL, ?1, ?2, ?3, ?4, ?5, ?6, ?7, NULL)"
//            , nativeQuery = true)
//    void insertVaccineReserve(int userId, int vaccineId, int hospitalId, int vaccineCount, Date date, String status, Date createDate);
}
