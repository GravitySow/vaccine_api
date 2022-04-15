package com.vaccine.vaccine.services;

import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import com.vaccine.vaccine.model.LoginInfo;

import java.util.List;
import java.util.Map;

public interface StaffService {
    LoginInfo Login(Map<String, Object> inputs);

    List<VaccineReserveHopital> getVaccineReserve(Map<String, Object> inputs);
}
