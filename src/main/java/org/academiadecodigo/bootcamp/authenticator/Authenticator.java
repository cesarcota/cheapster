package org.academiadecodigo.bootcamp.authenticator;

import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Authenticator {

    @Autowired
    private UserService userService;

    public boolean authenticateByEmail(String email, String password){
        User user = userService.findByEmail(email);
        return (user!=null) && (user.getPassword().equals(password));
    }



}
