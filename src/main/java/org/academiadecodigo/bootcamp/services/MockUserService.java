package org.academiadecodigo.bootcamp.services;


import org.academiadecodigo.bootcamp.models.Group;
import org.academiadecodigo.bootcamp.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockUserService implements UserService{

    private Map<String,User> userMap = new HashMap<>();

    @Override
    public void addUser(User user) {

        if(user==null){
            return;
        }

        userMap.put(user.getEmail(),user);

    }

    @Override
    public void removeUser(User user) {

        if(user==null){
            return;
        }

        userMap.remove(user.getEmail());

    }

    @Override
    public User findByEmail(String email) {

        return userMap.get(email);

    }

    @Override
    public List<User> findAllUsers() {

        return new ArrayList<User>(userMap.values());
    }

    @Override
    public void updateRound(Integer id) {

    }


}
