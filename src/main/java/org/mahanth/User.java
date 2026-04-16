package org.mahanth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User { // POJO - Plain Old Java Object

    @Id
    private int uId;
    private String uName;
    private String uEmail;

    public User(){

    }
    public User(int uId, String uName, String uEmail) {
        this.uId = uId;
        this.uName = uName;
        this.uEmail = uEmail;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public int getuId() {
        return uId;
    }

    public String getuName() {
        return uName;
    }
    public String getuEmail() {
        return uEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
