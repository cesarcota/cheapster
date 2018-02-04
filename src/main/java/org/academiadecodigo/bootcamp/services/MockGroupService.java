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
    public Group findById(Integer id) {

        return groupMap.get(id);

    }


}
