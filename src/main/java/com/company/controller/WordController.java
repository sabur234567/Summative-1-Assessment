package com.company.controller;


import com.company.model.Quote;
import com.company.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    private List<Word> wordList;
    private final static Random randomizer = new Random();

    public WordController(){
        wordList = new ArrayList<>();

        wordList.add(new Word(1234, "API", "Application Programming Interface"));
        wordList.add(new Word(3215, "Coronagraph", "instrument for viewing the corona of the sun"));
        wordList.add(new Word(2723, "xerarch", "growing in dry places"));
        wordList.add(new Word(2151, "zendik", "heretic; magician"));
    }
    @RequestMapping(value= "/word", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getWordandDefinition() {
        String wordAndDefinition = null;
        int index = randomizer.nextInt(wordList.size());
        Word validWord = wordList.get(index);
        wordAndDefinition = validWord.getWord() + ":" + validWord.getDefinition();
        return wordAndDefinition;
    }
}
