package org.academiadecodigo.bootcamp.controllers;

import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.UserService;
import org.academiadecodigo.bootcamp.utils.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    // Map the URL/Verb to the method
    @RequestMapping(method = RequestMethod.GET, value = {"","/","/login"})
    public String showLogin(Model model) {

        // Add an attribute to the request
        model.addAttribute(Attribute.user, new User());

        // Return the view name
        return Attribute.login;

    }

}
