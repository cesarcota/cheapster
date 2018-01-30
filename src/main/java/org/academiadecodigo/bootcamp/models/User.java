package org.academiadecodigo.bootcamp.models;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String userName;
    private String password;
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

    public String getEmail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public Map<Integer, Group> getGroupMap() {
        return groupMap;
    }

    public void setGroupMap(Map<Integer, Group> groupMap) {
        this.groupMap = groupMap;
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
}
