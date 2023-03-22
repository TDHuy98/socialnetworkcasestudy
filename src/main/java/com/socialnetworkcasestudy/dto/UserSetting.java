package com.socialnetworkcasestudy.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserSetting {
    private Long id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String mobile;
    private String intro;
    private String profile;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"yyyy-MM-dd"})
    private Date dob;

    public UserSetting() {
    }

    public UserSetting(Long id, String firstname, String middlename, String lastname, String email, String mobile, String intro, String profile, Date dob) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.intro = intro;
        this.profile = profile;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
