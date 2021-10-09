package com.company.controller;

import com.company.model.Magic8Ball;
import com.company.model.Quote;
import com.company.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8BallController {
    private List<Magic8Ball> magic8BallList;
    private List<String> answerList;
    private static int idCounter =1234;
    private final static Random randomizer = new Random();

    public Magic8BallController(){
        answerList = new ArrayList<>();
        magic8BallList = new ArrayList<>();

        answerList.add("Magic 8 ball says Very Doubtful");
        answerList.add("Magic 8 ball says Very Likely");
        answerList.add("Magic 8 ball says Without a Doubt");
        answerList.add("Magic 8 ball affirms Yes");
        answerList.add("Magic 8 ball said it's certain");
        answerList.add("Magic 8 ball says Ask Again Later");
    }
    @RequestMapping(value= "/8ball", method = RequestMethod.POST)
    public String eightBallQuestion(@RequestBody String question){
        String answer = null;
        int index = randomizer.nextInt(answerList.size());
        answer = answerList.get(index);
        magic8BallList.add(new Magic8Ball(idCounter++, question, answer));
        return answer;
    }
}
