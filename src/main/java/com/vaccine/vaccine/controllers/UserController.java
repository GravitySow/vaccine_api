package com.vaccine.vaccine.controllers;

import com.vaccine.vaccine.entities.Hospital;
import com.vaccine.vaccine.entities.Users;
import com.vaccine.vaccine.entities.Vaccine;
import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.model.LoginInfo;
import com.vaccine.vaccine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public void register (@RequestBody Map<String, Object> inputs) throws ParseException {
        userService.register(inputs);
    }

    @PostMapping(value = "/login")
    public LoginInfo login(@RequestBody Map<String, String> inputs){
        return userService.login(inputs);
    }

    @PostMapping(value = "/getusers")
    public Page<Users> getUser(@RequestParam("page") String page, @RequestParam("size") String size){
        return userService.getUsers(PageRequest.of(Integer.valueOf(page), Integer.valueOf(size)));
    }

    @PostMapping(value = "/getvaccine")
    public List<Vaccine> getVaccine(){
        return userService.getVaccine();
    }

    @PostMapping(value = "/getcovidvaccine")
    public List<Vaccine> getCovidVaccine(){
        return userService.getCovidVaccine();
    }

    @PostMapping(value = "/getothervaccine")
    public List<Vaccine> getOtherVaccine(){
        return userService.getOtherVaccine();
    }

    @PostMapping(value = "/gethospital")
    public List<Hospital> getHospital(){
        return userService.getHospital();
    }


    @PostMapping(value = "/gethospitalvaccine")
    public void getHospitalVaccine(){

    }

    @PostMapping(value = "/getvaccinereserve")
    public  List<VaccineReserve> getVaccineReserve(@RequestBody Map<String, Object> inputs){
        return userService.getVaccineReserve(inputs);
    }

    @PostMapping(value = "/reservevaccine")
    public void reserveVaccine(@RequestBody Map<String, Object> inputs) throws ParseException{
        userService.reserveVaccine(inputs);
    }
}
