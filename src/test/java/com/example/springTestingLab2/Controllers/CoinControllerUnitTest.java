package com.example.springTestingLab2.Controllers;

import com.example.springTestingLab2.Services.CoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CoinControllerUnitTest {

    @Test
    void shouldReturnBitcoinPrice() {
        CoinService bitcoinService = Mockito.mock(CoinService.class);
        BigDecimal bitcoinPrice_expected = BigDecimal.valueOf(23080.8009588567122947);
      CoinController bitcoinController = new CoinController(bitcoinService);
        when(bitcoinService.getCoinPrice("bitcoin")).thenReturn(bitcoinPrice_expected);
        BigDecimal bitcoinPrice_actual = bitcoinController.getBitcoin("bitcoin");
        assertEquals(bitcoinPrice_expected, bitcoinPrice_actual);
    }

}