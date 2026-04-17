package org.mahanth;

import jakarta.persistence.*;

@Entity //(name="Users") // This is for entity name which can be modified by user with corresponding value
@Table(name="Users_Data")
/*
Table name and entity name were quite different whereas table name is derived from entity name
 */
public class User { // POJO - Plain Old Java Object

    @Id
    private int uId;
//    @Transient // Using this annotation the data will not be stored in table in database which is temporary data
//    private String uName;
    @Embedded
    private UserName uName;
    @Column(name="User_Email") // User defined column name can be used with the @coloumn annotation
    private String uEmail;

    public User(){

    }
//    public User(int uId, String uName, String uEmail) {
//        this.uId = uId;
//        this.uName = uName;
//        this.uEmail = uEmail;
//    }

    public void setuId(int uId) {
        this.uId = uId;
    }
//    public void setuName(String uName) {
//        this.uName = uName;
//    }
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public int getuId() {
        return uId;
    }
//    public String getuName() {
//        return uName;
//    }
    public String getuEmail() {
        return uEmail;
    }

    public UserName getuName() {
        return uName;
    }

    public void setuName(UserName uName) {
        this.uName = uName;
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
