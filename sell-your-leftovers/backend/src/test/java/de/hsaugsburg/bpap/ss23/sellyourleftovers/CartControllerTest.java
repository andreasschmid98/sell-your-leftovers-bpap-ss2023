package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.CartRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.service.CartService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CartService cartService;

    @Test
    @WithMockUser(username = "test@test.com", password = "test")
    public void testGetAllCartItems() throws Exception {

        mockMvc.perform(get("/api/cart"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Württemberg Qualitätswein rot 6x 700ml")));
    }

    @Test
    @WithMockUser(username = "test@test.com", password = "test")
    @Transactional
    public void testAddCartItem() throws Exception {

        CartRequest cartRequest = new CartRequest(10L);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/cart/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(username = "test@test.com", password = "test")
    @Transactional
    public void testRemoveCartItem() throws Exception {

        CartRequest cartRequest = new CartRequest(22L);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/cart/remove")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cartRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
