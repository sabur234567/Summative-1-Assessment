package com.company.controller;


import com.company.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    private List<Quote> quoteList;
    private final static Random randomizer = new Random();

    public QuoteController() {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote("YOLO", "Drake", 1234));
        quoteList.add(new Quote("Test", "Testing123", 2345));
        quoteList.add(new Quote("Test2", "Testing321", 2625));
    }
    @RequestMapping(value= "/quote", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Quote getQuote() {
        Quote returnQuote = null;
        int index = randomizer.nextInt(quoteList.size());
        returnQuote = quoteList.get(index);
        return returnQuote;
    }
}

