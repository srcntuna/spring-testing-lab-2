package com.example.springTestingLab2.Services;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BitcoinServiceIntegrationTest {

    @Test
    void shouldReturnBitcoinPrice(){

        BitcoinService bitcoinService = new BitcoinService();
        BigDecimal firstBitcoinPrice = bitcoinService.getBitcoinPrice();
        assertThat(firstBitcoinPrice).isNotNull();
        BigDecimal secondBitcoinPrice = bitcoinService.getBitcoinPrice();
        assertThat(secondBitcoinPrice).isNotNull();

        //not doing that because they could be same
//        assertThat(firstBitcoinPrice).isNotEqualTo(secondBitcoinPrice);

    }

}