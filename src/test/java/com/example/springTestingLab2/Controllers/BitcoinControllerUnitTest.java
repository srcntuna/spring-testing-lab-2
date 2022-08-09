package com.example.springTestingLab2.Controllers;

import com.example.springTestingLab2.Controllers.BitcoinController;
import com.example.springTestingLab2.Services.BitcoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BitcoinControllerUnitTest {

    @Test
    void shouldReturnBitcoinPrice() {
        BitcoinService bitcoinService = Mockito.mock(BitcoinService.class);
        BigDecimal bitcoinPrice_expected = BigDecimal.valueOf(23080.8009588567122947);
        BitcoinController bitcoinController = new BitcoinController(bitcoinService);
        when(bitcoinService.getBitcoinPrice()).thenReturn(bitcoinPrice_expected);
        BigDecimal bitcoinPrice_actual = bitcoinController.getBitcoin();
        assertEquals(bitcoinPrice_expected, bitcoinPrice_actual);
    }

}