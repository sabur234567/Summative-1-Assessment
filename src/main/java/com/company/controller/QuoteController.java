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
        quoteList.add(new Quote("Live your life", "Everybody", 2345));
        quoteList.add(new Quote("Every human heart is human.", "Henry Wadsworth Longfellow", 2625));
        quoteList.add(new Quote("Emulation is a noble and just passion, full of appreciation.", "J. C. F. von Schiller", 1624));
        quoteList.add(new Quote("To teach is to learn twice.", "Joseph Joubert", 1631));
        quoteList.add(new Quote("Persistent people begin their success where others end in failure.", "Edward Eggleston", 7326));
        quoteList.add(new Quote("God hasn't called me to be successful. He's called me to be faithful.", "Mother Teresa", 4326));
        quoteList.add(new Quote("If a free society cannot help the many who are poor, it cannot save the few who are rich.", "John F. Kennedy", 8331));
        quoteList.add(new Quote("No man will ever bring out of the Presidency the reputation which carries him into it.", "Thomas Jefferson", 7423));
        quoteList.add(new Quote("Not simply one of the virtues but the form of every virtue at the testing point, which means at the point of highest reality.", "C.S. Lewis", 6325));
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

