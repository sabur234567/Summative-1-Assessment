package com.company.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Magic8Ball {
    @NotEmpty(message= "You must enter a value for an ID")
    @Size(min=4, max =4, message = "ID must be 4 digits")
    private int id;
    private String Question;
    @NotEmpty (message= "You must enter a value for an Answer")
    private String Answer;

    public Magic8Ball(){}
    @NotEmpty(message = "You must supply a value for quote.")
    public Magic8Ball(int id, String question, String answer){
        this.Question = question;
        this.Answer = answer;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
