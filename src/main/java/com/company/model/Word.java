package com.company.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Word {
    @NotEmpty (message= "You must enter a value for an ID")
    @Size(min=4, max =4, message = "ID must be 4 digits")
    private int id;
    @NotEmpty(message= "You must enter a value for word")
    private String word;
    @NotEmpty (message= "You must enter a value for a definition")
    private String definition;

    public Word(){}
    @NotEmpty(message = "You must supply a value for quote.")
    public Word(int id, String word, String definition){
        this.word = word;
        this.definition = definition;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
