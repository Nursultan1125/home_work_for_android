package com.example.myapplication;

public class Question {
    private String text;


    private boolean answer;
    public Question(String text, boolean answer){
        this.text = text;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return getText();
    }

    public String getText() {
        return text;
    }

    public boolean getAnswer() {
        return answer;
    }
}
