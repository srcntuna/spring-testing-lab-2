package com.example.springTestingLab2.Controllers;

import com.example.springTestingLab2.Services.BitcoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BitcoinController.class)

class BitcoinControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BitcoinService bitcoinService;

    @WithMockUser(username = "fakeuser", authorities = "admin") // added authorities to our mock user
    @Test
    void shouldReturnBitcoinPrice() throws Exception {

        BigDecimal bitcoinPrice = BigDecimal.valueOf(22982.4325434);

        Mockito.when(bitcoinService.getBitcoinPrice("bitcoin")).thenReturn(bitcoinPrice);

        mockMvc.perform(get("/getPrice/bitcoin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(bitcoinPrice))));
    }


}