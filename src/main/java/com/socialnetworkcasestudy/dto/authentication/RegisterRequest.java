package com.socialnetworkcasestudy.dto.authentication;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.sql.Date;

public class RegisterRequest {
    private String firstname;
    private String middlename;
    @NonNull
    private String lastname;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String mobile;
    @NonNull
    private String password;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"yyyy-MM-dd"})
    private Date dateOfBirth;

    public RegisterRequest() {
    }

    public RegisterRequest(String firstname, String middlename, String lastname,
                           String username, String email, String mobile, String password, Date dateOfBirth) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
