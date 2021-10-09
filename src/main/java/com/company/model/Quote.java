package com.company.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Quote {
    @NotEmpty(message= "You must enter a alue for an author")
    private String author;
    @NotEmpty (message= "You must enter a alue for an ID")
    @Size(min=4, max =4, message = "ID must be 4 digits")
    private int id;
    @NotEmpty (message= "You must enter a value for a Quote")
    private String quote;

    public Quote() { }
    @NotEmpty(message = "You must supply a value for quote.")
    public Quote(String quote,String author, int id){
        this.quote = quote;
        this.author = author;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return getId() == quote1.getId() && Objects.equals(getAuthor(), quote1.getAuthor()) && Objects.equals(getQuote(), quote1.getQuote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getQuote(), getId());
    }
}
