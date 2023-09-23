package com.syscode.syscode.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class AddressIntegrationTest {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
  void testGetRandomAddressWithBasicAuth() throws Exception {
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/api/v1/address")
                .header(
                    HttpHeaders.AUTHORIZATION, "Basic " + getBase64Credentials("admin", "admin"))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
        .andExpect(MockMvcResultMatchers.jsonPath("$.address").isNotEmpty());
  }

  private String getBase64Credentials(String username, String password) {
    String credentials = username + ":" + password;
    return new String(java.util.Base64.getEncoder().encode(credentials.getBytes()));
  }
}
