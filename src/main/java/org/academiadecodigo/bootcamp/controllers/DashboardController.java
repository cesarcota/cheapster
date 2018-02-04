package org.academiadecodigo.bootcamp.controllers;

import org.academiadecodigo.bootcamp.services.MockGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("group")
public class DashboardController {

    @Autowired
    private MockGroupService mockGroupService;

    @RequestMapping(method = RequestMethod.GET, value = "/dashboard")
    public String showDashboard(Model model){
        model.addAttribute("groupList", mockGroupService.findAllGroups());
        return "dashboard";
    }
}


