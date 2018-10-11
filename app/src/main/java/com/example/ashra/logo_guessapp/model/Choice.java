package com.example.ashra.logo_guessapp.model;

public class Choice {
    private String choice1;
    private String choice3;
    private String choice4;
    private String choice2;

    public Choice(){ }

    public Choice(String choice1, String choice2, String choice3, String choice4) {
        this.choice1 = choice1;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice2 = choice2;
    }
    public String getChoice1(){
        return this.choice1;
    }

    public String getChoice3(){
        return this.choice3;
    }

    public String getChoice4(){
        return this.choice4;
    }

    public String getChoice2(){
        return this.choice2;
    }
}
