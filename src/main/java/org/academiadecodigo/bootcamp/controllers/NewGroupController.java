package org.academiadecodigo.bootcamp.controllers;

import org.academiadecodigo.bootcamp.models.Group;
import org.academiadecodigo.bootcamp.services.MockGroupService;
import org.academiadecodigo.bootcamp.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes({"user", "group"})
public class NewGroupController {

    @Autowired
    private MockGroupService mockGroupService;

    @RequestMapping(method = RequestMethod.GET, value ="/newgroup")
    public String showNewGroupPage(Model model, Group group){
        model.addAttribute("group", new Group());
        return "newgroup";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addGroup(Model model, @ModelAttribute("group") Group group, String groupName, Type type){
        group.setType(type);
        group.setGroupName(groupName);
        mockGroupService.addGroup(group);

        System.out.println("ENTERED HERE");

        model.addAttribute("sucess", "login sucess");
        return "redirect:/dashboard";
    }






}
