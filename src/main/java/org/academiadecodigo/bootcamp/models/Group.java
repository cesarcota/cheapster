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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!id.equals(group.id)) return false;
        if (!groupName.equals(group.groupName)) return false;
        if (type != group.type) return false;
        return userMap.equals(group.userMap);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + groupName.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + userMap.hashCode();
        return result;
    }
}
