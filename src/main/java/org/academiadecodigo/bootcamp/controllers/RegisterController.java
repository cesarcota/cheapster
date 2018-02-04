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
    public String doRegister(Model model , @Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){


        //If the user/pass fields are empty, display the same view
        if(bindingResult.hasErrors()){
            return Attribute.register;
        }


        if(userService.findByEmail(user.getEmail())!=null){
            model.addAttribute("error","There is already an user with that email.");
            return Attribute.register;
        }


        userService.addUser(user);

        redirectAttributes.addFlashAttribute(Attribute.success, "User "+user.getUserName()+" was created successfully!");

        return Attribute.redirect(Attribute.login);



    }

}
