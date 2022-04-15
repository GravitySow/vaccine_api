package com.vaccine.vaccine.model;

public class LoginInfo {
    Boolean status;
    int userId;
    Boolean staff = false;
    int hospitalId;

    public LoginInfo() {
        this.status = false;
    }

    public LoginInfo(int userId) {
        this.status = true;
        this.userId = userId;
    }

    public LoginInfo(int userId, int hospitalId) {
        this.status = true;
        this.userId = userId;
        this.staff = true;
        this.hospitalId = hospitalId;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public Boolean getStaff() {
        return staff;
    }

    public int getHospitalId() {
        return hospitalId;
    }
}
