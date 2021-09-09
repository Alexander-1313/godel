package com.rybaq.simplewebapp.dto;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String type;

    Gender(String type) {
        this.type = type;
    }

    public String type(){
        return type;
    }
}
