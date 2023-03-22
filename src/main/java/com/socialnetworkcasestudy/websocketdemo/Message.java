package com.socialnetworkcasestudy.websocketdemo;

public class Message {
    private long id;
    private String message;
    private long idSenders;
    private long idRev;

    public Message(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public long getIdSenders() {
        return idSenders;
    }

    public void setIdSenders(long idSenders) {
        this.idSenders = idSenders;
    }

    public long getIdRev() {
        return idRev;
    }

    public void setIdRev(long idRev) {
        this.idRev = idRev;
    }

    public Message(String message, long idSenders, long idRev) {
        this.message = message;
        this.idSenders = idSenders;
        this.idRev = idRev;
    }
}
