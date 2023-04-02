package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This defines test cases for all API-endpoints of the ProductController.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void testGetAllProducts() throws Exception {

        mockMvc.perform(get("/api/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(22)))
                .andExpect(jsonPath("$[2].name", is("Sprizzero Bitterorange 10x 300ml")));
    }

    @Test
    @WithMockUser
    public void testGetProductById() throws Exception {
        mockMvc.perform(get("/api/product/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Sprizzero Bitterorange 10x 300ml")));
    }

}
