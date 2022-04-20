package com.vaccine.vaccine.services;

import com.vaccine.vaccine.entities.Staff;
import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.entities.VaccineReserveHopital;
import com.vaccine.vaccine.model.LoginInfo;
import com.vaccine.vaccine.repositories.StaffRepository;
import com.vaccine.vaccine.repositories.VaccineReserveHopitalRepository;
import com.vaccine.vaccine.repositories.VaccineReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private VaccineReserveRepository vaccineReserveRepository;
    @Autowired
    private VaccineReserveHopitalRepository vaccineReserveHopitalRepository;

    public LoginInfo Login(Map<String, Object> inputs){
        String username = (String) inputs.get("username");
        String password = (String) inputs.get("password");
        LoginInfo loginInfo = new LoginInfo();
        Staff login = staffRepository.login(username, password);
        if(login != null){
            loginInfo = new LoginInfo(login.getId(), login.getHospitalId());
        }
        return loginInfo;
    }

    public List<VaccineReserveHopital> getVaccineReserve(Map<String, Object> inputs){
        int hospitalId = (int) inputs.get("hospitalId");
        return vaccineReserveHopitalRepository.findByHospitalId(hospitalId);
    }

    public void reserveVaccine(Map<String, Object> inputs){
        VaccineReserve v = new VaccineReserve();
    }
}
