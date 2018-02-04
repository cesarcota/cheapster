package org.academiadecodigo.bootcamp.utils;

public class Attribute {


    public static final String login="login";
    public static final String user="user";
    public static final String register="register";

    public static String redirect(String attribute){
        return "redirect:/"+attribute;
    }


}
