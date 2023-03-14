package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.OrderLineItemsDto;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.OrderRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void testPlaceOrder() throws Exception {

        OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto("A1", 5);
        List<OrderLineItemsDto> orderLineItems = new ArrayList<>();
        orderLineItems.add(orderLineItemsDto);

        OrderRequest orderRequest = new OrderRequest(orderLineItems);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location",
                        Matchers.containsString("/api/order/1")));
    }
}
