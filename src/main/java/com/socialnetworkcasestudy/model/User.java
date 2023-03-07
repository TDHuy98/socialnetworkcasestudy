package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column(unique = true)

    @Length(min = 10, max = 10)
    private String mobile;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @Length(min = 3, max = 32)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_userMessage",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Collection<Message>message=new ArrayList<>();

    @OneToMany
    private  Collection<Comment> comments=new ArrayList<>();


    @Column()
    @DateTimeFormat(fallbackPatterns = "dd/mm/yyyy")
    private Instant createdAt;

    @Column
    @DateTimeFormat(fallbackPatterns = "dd/mm/yyyy")
    private Instant lastLogin;


    private String intro;

    private String profile;


    public User() {
    }

    public User(Long id, String firstName, String middleName, String lastName, String mobile,
                String email, String password, Collection<Message> message,
                Instant createdAt, Instant lastLogin, String intro, String profile) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.message = message;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Collection<Message> getMessage() {
        return message;
    }

    public void setMessage(Collection<Message> message) {
        this.message = message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
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
}
