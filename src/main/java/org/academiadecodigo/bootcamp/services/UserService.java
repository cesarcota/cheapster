package org.academiadecodigo.bootcamp.services;

import org.academiadecodigo.bootcamp.models.Group;
import org.academiadecodigo.bootcamp.models.User;

import java.util.List;

public interface UserService extends Service {

    void addUser(User user);

    void removeUser(User user);

    User findByEmail(String email);

    List<User> findAllUsers();

    void updateRound(Integer id);



}
