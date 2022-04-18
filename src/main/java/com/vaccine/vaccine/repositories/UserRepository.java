package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT u.id FROM `user` u WHERE `idcardno` = ?1 and password = ?2", nativeQuery = true)
    Object login(String idcardno, String password);

//    @Query(value = "SELECT u.* FROM `Users_Vaccine_Reserve` u INNER JOIN `Vaccine_Reserve` v ON u.vaccine_reserve_id = v.id WHERE u.user_id = ?1", nativeQuery = true)
//    List<UserVaccineReserve> getVaccineReserve(int userId);
}
