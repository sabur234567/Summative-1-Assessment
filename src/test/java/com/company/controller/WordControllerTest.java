package com.company.controller;

import com.company.model.Quote;
import com.company.model.Word;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper used to convert Java Objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    //A list of quotes for testing purposes
    private List<Quote> quoteList;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnRandomWordAnd204StatusCode () throws Exception {
        // ACT
        mockMvc.perform(get("/word"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }
}
