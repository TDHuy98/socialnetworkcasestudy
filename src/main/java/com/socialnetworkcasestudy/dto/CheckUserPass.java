package com.socialnetworkcasestudy.dto;

public class CheckUserPass {
    private final Long userId;
    private final String password;

    public CheckUserPass(Long userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

}
