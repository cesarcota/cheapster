package org.academiadecodigo.bootcamp.controllers;

import org.academiadecodigo.bootcamp.authenticator.Authenticator;
import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.UserService;
import org.academiadecodigo.bootcamp.utils.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private Authenticator authenticator;

    // Map the URL/Verb to the method
    @RequestMapping(method = RequestMethod.GET, value = {"/register"})
    public String showRegister(Model model) {

        // Add an attribute to the request
        model.addAttribute(Attribute.user, new User());

        // Return the view name
        return Attribute.register;

    }


    @RequestMapping(params = Attribute.register, method = RequestMethod.POST,value ={"register"})
    public String doregister(Model model , @Valid @ModelAttribute("user") User user, BindingResult bindingResult){


        //If the user/pass fields are empty, display the same view
        if(bindingResult.hasErrors()){
            return Attribute.register;
        }

        //If Authenticator succeeds
        if(authenticator.authenticateByEmail(user.getEmail(),user.getPassword())){
            //Changes the name of the button to change between users and bootcamps
            return Attribute.redirect(Attribute.login);
        }else{
            model.addAttribute("error","Failed to register the user. Please fill the right way the fields.");
            return Attribute.redirect(Attribute.login);
        }

    }

}
