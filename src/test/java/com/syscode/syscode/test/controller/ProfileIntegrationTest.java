package com.syscode.syscode.test.controller;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ProfileIntegrationTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    UUID studentId = UUID.fromString("fa86fd87-7192-4fa3-bdcd-da93c2a8f4b9");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent() throws Exception {
        String jsonPayload = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";
        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/api/v1/profile")
                                .contentType("application/json")
                                .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", notNullValue()));
    }

    @Test
    void testPageableStudentList() throws Exception {
        int page = 0;
        int size = 10;
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/api/v1/profile")
                                .param("page", String.valueOf(page))
                                .param("size", String.valueOf(size))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.results[0].name", is("Admin")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.results[0].email", notNullValue()));
    }

    @Test
    void testDeleteStudent() throws Exception {
        mockMvc
                .perform(
                        MockMvcRequestBuilders.delete("/api/v1/profile/{id}", studentId)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateStudentById() throws Exception {
        String jsonPayload = "{\"name\": \"Name\", \"email\": \"email@example.com\"}";

        mockMvc
                .perform(
                        MockMvcRequestBuilders.put("/api/v1/profile/{id}", studentId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.id").value("fa86fd87-7192-4fa3-bdcd-da93c2a8f4b9"));
    }
}
