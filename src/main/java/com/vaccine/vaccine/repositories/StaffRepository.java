package com.vaccine.vaccine.repositories;

import com.vaccine.vaccine.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query(value = "SELECT * FROM `staff` u WHERE `username` = ?1 and `password` = ?2", nativeQuery = true)
    Staff login(String username, String password);
}
