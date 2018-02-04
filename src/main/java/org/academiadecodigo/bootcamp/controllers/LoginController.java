package org.academiadecodigo.bootcamp.controllers;

import org.academiadecodigo.bootcamp.authenticator.Authenticator;
import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.UserService;
import org.academiadecodigo.bootcamp.utils.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private Authenticator authenticator;

    // Map the URL/Verb to the method
    @RequestMapping(method = RequestMethod.GET, value = {"","/","/login"})
    public String showLogin(Model model) {

        // Add an attribute to the request
        model.addAttribute(Attribute.user, new User());
        //model.addAttribute(Attribute.success,"User "+username+" was created successfully");

        // Return the view name
        return Attribute.login;

    }

    @RequestMapping(params = Attribute.login, method = RequestMethod.POST,value ={"","/","/login"})
    public String doLogin(Model model , @ModelAttribute("user") User user, BindingResult bindingResult){

        //If the user/pass fields are empty, display the same view
        if(bindingResult.hasErrors()){
            return Attribute.login;
        }

        model.addAttribute(Attribute.error,"test");

        //If authenticate succeeds
        if(authenticator.authenticateByEmail(user.getEmail(),user.getPassword())){
            model.addAttribute(Attribute.error,"Authentication failed");
            return Attribute.redirect(Attribute.dashboard);
        }else{
            model.addAttribute(Attribute.error,"Authentication failed");
            return Attribute.login;
        }

    }

}
