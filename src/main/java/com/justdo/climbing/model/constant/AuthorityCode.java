package com.justdo.climbing.model.constant;

public enum AuthorityCode {
    ADMIN("관리자"),
    INSTRUCTOR("강사"),
    CLIENT("고객");

    private final String description;

    AuthorityCode(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
