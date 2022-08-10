package com.example.springTestingLab2.Services;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CoinServiceIntegrationTest {

    @WithMockUser(username = "fakeuser", authorities = "admin") // added authorities to our mock user
    @Test
    void shouldReturnBitcoinPrice(){

        CoinService bitcoinService = new CoinService();
        BigDecimal firstBitcoinPrice = bitcoinService.getCoinPrice("bitcoin");
        assertThat(firstBitcoinPrice).isNotNull();
        BigDecimal secondBitcoinPrice = bitcoinService.getCoinPrice("bitcoin");
        assertThat(secondBitcoinPrice).isNotNull();

        //not doing that because they could be same
//        assertThat(firstBitcoinPrice).isNotEqualTo(secondBitcoinPrice);

    }

}