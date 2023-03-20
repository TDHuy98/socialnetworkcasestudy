package com.socialnetworkcasestudy.dto;

public class UserPass {
    private final Long userId;
    private final String oldPassword;
    private final String newPassword;

    public UserPass(Long userId, String oldPassword, String newPassword) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
