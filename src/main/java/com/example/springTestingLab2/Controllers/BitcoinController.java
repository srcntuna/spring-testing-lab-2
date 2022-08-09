package com.example.springTestingLab2.Controllers;

import com.example.springTestingLab2.Services.BitcoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BitcoinController {

    private BitcoinService bitcoinService;

    public BitcoinController(BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }


    @GetMapping("/getPrice/{coinName}")
    public BigDecimal getBitcoin(@PathVariable String coinName) {
        return bitcoinService.getBitcoinPrice(coinName);
    }

}
