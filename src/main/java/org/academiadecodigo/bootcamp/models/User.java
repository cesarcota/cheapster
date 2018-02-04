package org.academiadecodigo.bootcamp.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class User {

    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    private String userName;

    @NotNull(message = "password is mandatory")
    @NotBlank(message = "password is mandatory")
    @Size(min=3, max=64, message = "password must have between 3 ad 64 characters")
    private String password;

    @NotNull(message = "email is mandatory")
    @NotBlank(message = "email is mandatory")
    @Email
    private String email;


    private Map<Integer, Group> groupMap=  new HashMap<>();


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Integer, Group> getGroupMap() {
        return groupMap;
    }

    public void setGroupMap(Map<Integer, Group> groupMap) {
        this.groupMap = groupMap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", groupMap=" + groupMap +
                '}';
    }
}
