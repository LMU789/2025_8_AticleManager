package org.example.vo;

public class Member {

    private int id;
    private String loginId;
    private String loginPassword;
    private String loginName;
    private String regDate;
    private String updateDate;

    public Member(int id, String loginId, String loginPassword, String loginName, String regDate) {
        this.id = id;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.loginName = loginName;
        this.regDate = regDate;
        this.updateDate = regDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", loginName='" + loginName + '\'' +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
