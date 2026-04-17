package org.mahanth;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserName {
    private String firstName;
    private String middleName;
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "firstName='" + firstName + '\'' +
                ", MiddleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
