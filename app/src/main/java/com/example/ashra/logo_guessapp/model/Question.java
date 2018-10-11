package com.example.ashra.logo_guessapp.model;

public class Question {
    private String imgUrl;
    private String type;
    private String rightAnswer;
    private String choice1;
    private String choice3;
    private String choice4;
    private String choice2;

    public Question(){ }

    public Question(String imgUrl, String type, String rightAnswer, String choice1, String choice2, String choice3, String choice4) {
        this.imgUrl = imgUrl;
        this.type = type;
        this.rightAnswer = rightAnswer;
        this.choice1 = choice1;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice2 = choice2;
    }

    public String getImgUrl(){
        return this.imgUrl;
    }

    public String getType(){
        return this.type;
    }

    public String getRightAnswer(){
        return this.rightAnswer;
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

    public void setChoice1(String choice1){
        this.choice1 = choice1;
    }

    public void setChoice3(String choice3){
        this.choice3 = choice3;
    }

    public void setChoice4(String choice4){
        this.choice4 = choice4;
    }

    public void setChoice2(String choice2){
        this.choice2 = choice2;
    }
}
