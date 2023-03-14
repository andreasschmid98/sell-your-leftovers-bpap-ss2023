package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.ProductRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.ProductRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private DataSource dataSource;

    @BeforeAll
    void initDatabase() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("product.sql"));
        populator.execute(dataSource);
    }

    @Test
    public void testGetAllProducts() throws Exception {

        mockMvc.perform(get("/api/product"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[2].name", is("TEST_PROD_3")));
    }

    @Test
    public void testGetProductById() throws Exception {
        mockMvc.perform(get("/api/product/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("TEST_PROD_2")));
    }

    @Test
    @WithMockUser
    public void testCreateProduct() throws Exception {

        ProductRequest productRequest = ProductRequest
                .builder()
                .skuCode("A5")
                .name("TEST_PROD_5")
                .description("TEST_DESCR_5")
                .price(new BigDecimal(1))
                .quantity(1)
                .category(null)
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location",
                        Matchers.containsString("/api/product/5")));

        productRepository.deleteById(5L);

    }
}

