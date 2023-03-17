package com.socialnetworkcasestudy.dto;

public class UserPass {
    private final Long userId;
    private final String password;

    public UserPass(Long userId, String password) {
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
