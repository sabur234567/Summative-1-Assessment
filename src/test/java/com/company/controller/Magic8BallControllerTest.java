package com.company.controller;

import com.company.model.Magic8Ball;
import com.company.model.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class Magic8BallControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private List<String> answerList;
    //ObjectMapper used to convert Java Objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();
    private final static Random randomizer = new Random();
    //A list of quotes for testing purposes
    private List<Quote> quoteList;

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void shouldReturnRandomAnswerAnd204StatusCode () throws Exception {
        answerList = new ArrayList<>();
        answerList.add("Magic 8 ball says Very Doubtful");
        answerList.add("Magic 8 ball says Very Likely");
        answerList.add("Magic 8 ball says Without a Doubt");
        answerList.add("Magic 8 ball affirms Yes");
        answerList.add("Magic 8 ball said it's certain");
        answerList.add("Magic 8 ball says Ask Again Later");

        String requestBody = "Should I have Dinner tonight?";
        String inputJson = mapper.writeValueAsString(requestBody);

        int index = randomizer.nextInt(answerList.size());
        String answer = answerList.get(index);
        String outputJson = mapper.writeValueAsString(answer);

        mockMvc.perform(
                post("/8ball")             // Perform the POST request
                .content(inputJson)
                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())                          // Print results to console
                .andExpect(status().isCreated())             // ASSERT (status code is 200)
                .andExpect(content().json(outputJson));
    }

}
