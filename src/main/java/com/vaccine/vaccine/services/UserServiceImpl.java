package com.vaccine.vaccine.services;

import com.vaccine.vaccine.entities.Hospital;
import com.vaccine.vaccine.entities.Users;
import com.vaccine.vaccine.entities.Vaccine;
import com.vaccine.vaccine.entities.VaccineReserve;
import com.vaccine.vaccine.model.LoginInfo;
import com.vaccine.vaccine.repositories.HospitalRepository;
import com.vaccine.vaccine.repositories.UserRepository;
import com.vaccine.vaccine.repositories.VaccineRepository;
import com.vaccine.vaccine.repositories.VaccineReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private VaccineReserveRepository vaccineReserveRepository;

    public Page<Users> getUsers(PageRequest pageRequest){
        return userRepository.findAll(pageRequest);
    }

    @Override
    public List<Vaccine> getVaccine() {
        return vaccineRepository.findAll();
    }

    @Override
    public List<Vaccine> getCovidVaccine() {
        return vaccineRepository.findCovidVaccine();
    }

    @Override
    public List<Vaccine> getOtherVaccine() {
        return vaccineRepository.findOtherVaccine();
    }

    @Override
    public LoginInfo login(Map<String, String> inputs){
        String idcardno = inputs.get("idcardno");
        String password = inputs.get("password");
        Object login = userRepository.login(idcardno, password);
        LoginInfo loginInfo;
        if(login == null){
            loginInfo = new LoginInfo();
        }else{
            loginInfo = new LoginInfo((int) login);
        }
        return loginInfo;
    }

    @Override
    public void register(Map<String, Object> inputs) throws ParseException {
        Users u = new Users();
        u.setPassword((String) inputs.get("password"));
        u.setFirstname((String) inputs.get("firstname"));
        u.setSurname((String) inputs.get("surname"));
        u.setIdCardNO((String) inputs.get("idcardno"));
        u.setGender((String) inputs.get("gender"));
        u.setEmail((String) inputs.get("email"));
        u.setTel((String) inputs.get("tel"));
        u.setAddress((String) inputs.get("address"));
        u.setCreateDate(new Date());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String b = (String) inputs.get("birthday");
        Date birthday = format.parse(b);
        System.out.println(birthday);
        u.setBirthday(birthday);

        userRepository.save(u);
    }

    @Override
    public List<Hospital> getHospital(){
        return hospitalRepository.findAll();
    }

    public  List<VaccineReserve> getVaccineReserve(Map<String, Object> inputs) {
        // ใช้ id หา vaccine ที่จอง
        int userId = (int) inputs.get("userId");
        return vaccineReserveRepository.findByUserId(userId);
    }
}
