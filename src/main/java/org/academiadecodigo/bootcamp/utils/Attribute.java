package org.academiadecodigo.bootcamp.utils;

public class Attribute {


    public static final String login="login";
    public static final String user="user";
    public static final String register="register";
    public static final String success="success";
    public static final String dashboard="dashboard";
    public static final String error="error";




    public static String redirect(String attribute){
        return "redirect:/"+attribute;
    }


}
