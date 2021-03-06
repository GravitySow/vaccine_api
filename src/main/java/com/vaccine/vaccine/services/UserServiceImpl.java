package com.vaccine.vaccine.services;

import com.vaccine.vaccine.entities.*;
import com.vaccine.vaccine.model.LoginInfo;
import com.vaccine.vaccine.repositories.*;
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
    @Autowired
    private VaccineReserveInRepository vaccineReserveInRepository;

    public Page<Users> getUsers(PageRequest pageRequest){
        return userRepository.findAll(pageRequest);
    }

    public Users findUser(Map<String, Object> inputs){
        return userRepository.findById((int) inputs.get("userId"));
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
//        System.out.println(birthday);
        u.setBirthday(birthday);

        userRepository.save(u);
    }

    @Override
    public List<Hospital> getHospital(){
        return hospitalRepository.findAllHospital();
    }

    public  List<VaccineReserve> getVaccineReserve(Map<String, Object> inputs) {
        // ????????? id ?????? vaccine ??????????????????
        int userId = (int) inputs.get("userId");
        return vaccineReserveRepository.findByUserId(userId);
    }

    public void reserveVaccine(Map<String, Object> inputs) throws ParseException {
        VaccineReserveIn v = new VaccineReserveIn();
         v.setUserId((int) inputs.get("userId"));
         v.setVaccineId((int) inputs.get("vaccineId"));
         v.setHospitalId((int)inputs.get("hospitalId"));
         v.setVaccineCount((int) inputs.get("vaccineCount"));
         v.setStatus((int) inputs.get("hospitalId") == 0 ? null : "??????????????????????????????????????????????????????");
         v.setCreateDate(new Date());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String d = (String) inputs.get("date");
        Date date = format.parse(d);
        v.setDate(date);

        vaccineReserveInRepository.save(v);
    }
}
