package com.vaccine.vaccine.services;

import com.vaccine.vaccine.entities.Hospital;
import com.vaccine.vaccine.entities.Users;
import com.vaccine.vaccine.entities.Vaccine;
import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.model.LoginInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface UserService {
    Page<Users> getUsers(PageRequest pageRequest);

    List<Vaccine> getVaccine();

    LoginInfo login(Map<String, String> inputs);

    void register(Map<String, Object> inputs) throws ParseException;

    List<Hospital> getHospital();

    List<VaccineReserve> getVaccineReserve(Map<String, Object> inputs);
}
