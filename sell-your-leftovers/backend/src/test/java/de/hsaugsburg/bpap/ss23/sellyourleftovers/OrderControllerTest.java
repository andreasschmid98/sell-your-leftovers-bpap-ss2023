package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;

/**
 * This defines test cases for all API-endpoints of the OrderController.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "test@test.com", password = "test")
    public void testOrder() throws Exception {

        OrderRequest orderRequest = new OrderRequest(new ArrayList<>(List.of(1L, 2L, 3L)));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
