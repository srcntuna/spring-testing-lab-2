package com.example.springTestingLab2.Services;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BitcoinServiceIntegrationTest {

    @WithMockUser(username = "fakeuser", authorities = "admin") // added authorities to our mock user
    @Test
    void shouldReturnBitcoinPrice(){

        BitcoinService bitcoinService = new BitcoinService();
        BigDecimal firstBitcoinPrice = bitcoinService.getBitcoinPrice("bitcoin");
        assertThat(firstBitcoinPrice).isNotNull();
        BigDecimal secondBitcoinPrice = bitcoinService.getBitcoinPrice("bitcoin");
        assertThat(secondBitcoinPrice).isNotNull();

        //not doing that because they could be same
//        assertThat(firstBitcoinPrice).isNotEqualTo(secondBitcoinPrice);

    }

}