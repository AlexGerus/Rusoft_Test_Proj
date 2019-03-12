package com.rusoft.task.controllers;

import com.rusoft.task.Main;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Main.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientControllerTest {

    private static final String clientName = "Alex";
    private static final String clientAge = "19";
    private static final String carName = "Audi";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveClient() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/add-client")
                .param("clientName", clientName)
                .param("clientAge", clientAge)
                .param("carName", carName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/clients")
                .param("name", clientName)
                .param("model", carName)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }
}