package com.socialnetworkcasestudy.websocketdemo;

public class User {
    private String name;
    private String message;
    private Long idSender;
    private Long idRev;

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdRev() {
        return idRev;
    }

    public void setIdRev(Long idRev) {
        this.idRev = idRev;
    }

    public User(String name, String message, Long idSender, Long idRev) {
        this.name = name;
        this.message = message;
        this.idSender = idSender;
        this.idRev = idRev;
    }
}
