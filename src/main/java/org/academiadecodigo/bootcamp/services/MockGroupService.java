package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.models.Group;
import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.utils.Type;

import java.util.*;

public class MockGroupService implements GroupService {

    private Map<Integer, Group> groupMap=new HashMap<>();

    @Override
    public void addGroup(Group group) {

       if(group==null){
           return;
       }

        groupMap.put(group.getId(),group);

    }

    @Override
    public void removeGroup(Group group) {

        if(group==null){
            return;
        }

        groupMap.remove(group.getId());

    }

    @Override
    public List<Group> findAllGroups() {

        return new ArrayList<Group>(groupMap.values());

    }

    @Override
    public List<User> findAllUsers(Group group) {

        return new ArrayList<User>(group.getUserMap().values());
    }

    @Override
    public Group findById(Integer id) {

        return groupMap.get(id);

    }

    @Override
    public void setType(Group group,Type type) {

        if(group==null){
            return;
        }

        Group tempGroup=findById(group.getId());

        if(tempGroup==null){
            return;
        }

        tempGroup.setType(type);

    }
}
