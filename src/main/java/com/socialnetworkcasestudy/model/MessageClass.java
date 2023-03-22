package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MessageClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String message;
    private Long idSenders;
    private Long idRev;
    private Date crateAT;
    private Date updateAT;

    public MessageClass(Long id, String message, Long idSenders, Long idRev, Date crateAT, Date updateAT) {
        this.id = id;
        this.message = message;
        this.idSenders = idSenders;
        this.idRev = idRev;
        this.crateAT = crateAT;
        this.updateAT = updateAT;
    }

    public MessageClass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getIdSenders() {
        return idSenders;
    }

    public void setIdSenders(Long idSenders) {
        this.idSenders = idSenders;
    }

    public Long getIdRev() {
        return idRev;
    }

    public void setIdRev(Long idRev) {
        this.idRev = idRev;
    }

    public Date getCrateAT() {
        return crateAT;
    }

    public void setCrateAT(Date crateAT) {
        this.crateAT = crateAT;
    }

    public Date getUpdateAT() {
        return updateAT;
    }

    public void setUpdateAT(Date updateAT) {
        this.updateAT = updateAT;
    }
}
