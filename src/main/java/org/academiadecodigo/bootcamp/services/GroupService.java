package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.models.Group;
import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.utils.Type;

import java.util.List;

public interface GroupService extends Service {

    void addGroup(Group group);

    void removeGroup(Group group);

    List<Group> findAllGroups();

    Group findById(Integer id);

}
