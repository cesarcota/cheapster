package org.academiadecodigo.bootcamp.models;

import org.academiadecodigo.bootcamp.utils.Type;

import java.util.HashMap;
import java.util.Map;

public class Group {

    private Integer id;
    private String groupName;
    private Type type;
    private Map<String, User> userMap = new HashMap<>();


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
