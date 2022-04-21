package com.vaccine.vaccine.controllers;

import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import com.vaccine.vaccine.model.LoginInfo;
import com.vaccine.vaccine.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/staff")
@CrossOrigin("*")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(value = "/login")
    public LoginInfo login(@RequestBody Map<String, Object> inputs){
        return staffService.Login(inputs);
    }

    @PostMapping(value = "/getuserinformation")
    public void getUserInfomation(){

    }

    @PostMapping(value = "/getvaccinereserve")
    public List<VaccineReserveHopital> getVaccineReserve(@RequestBody Map<String, Object> inputs){
        return staffService.getVaccineReserve(inputs);
    }

    @PostMapping(value = "/checkvaccine")
    public void checkVaccine(@RequestBody Map<String, Object> inputs){
        staffService.checkVaccine(inputs);
    }
}
