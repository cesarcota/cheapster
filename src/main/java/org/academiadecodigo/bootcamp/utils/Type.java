package org.academiadecodigo.bootcamp.utils;

public enum Type {
    BEER ("Beer"), COFEE ("Cofee"), MEALS("Meals");

    private String type;
    Type(String s){
        type = s;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
