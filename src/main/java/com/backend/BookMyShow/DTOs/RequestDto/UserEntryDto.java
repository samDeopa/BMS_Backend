package com.backend.BookMyShow.DTOs.RequestDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class UserEntryDto {
    private  String name;
    private String email;
    private  int age;
    private String mobileNo;
    private String Address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
