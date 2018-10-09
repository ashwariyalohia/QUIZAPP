package com.example.ashra.logo_guessapp.model;

public class User {
    private String id;
    private String name;
    private Integer score;

    public User(){}

    public User(String id, String phone, Integer pass) {
        this.id = id;
        this.name = phone;
        this.score = pass;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Integer getScore(){
        return this.score;
    }
}
