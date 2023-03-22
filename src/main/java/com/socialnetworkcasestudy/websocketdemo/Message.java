package com.socialnetworkcasestudy.websocketdemo;

public class Message {
    private String content;
    private Long idUserSend;
    private Long iDuserRev;

    public Message() {
    }

    public Message(String content, Long idUserSend, Long iDuserRev) {
        this.content = content;
        this.idUserSend = idUserSend;
        this.iDuserRev = iDuserRev;
    }

    public Long getIdUserSend() {
        return idUserSend;
    }

    public void setIdUserSend(Long idUserSend) {
        this.idUserSend = idUserSend;
    }

    public Long getiDuserRev() {
        return iDuserRev;
    }

    public void setiDuserRev(Long iDuserRev) {
        this.iDuserRev = iDuserRev;
    }

    public Message(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
