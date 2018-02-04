package org.academiadecodigo.bootcamp.authenticator;

import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.UserService;

public class Authenticate {

    private UserService userService;

    public boolean authenticateByEmail(String email, String password){
        User user = userService.findByEmail(email);
        return (user!=null) && (user.getPassword().equals(password));
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
