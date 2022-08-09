package com.example.springTestingLab2.Controllers;

import com.example.springTestingLab2.Services.BitcoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BitcoinController {

    private BitcoinService bitcoinService;

    public BitcoinController(BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }


    @GetMapping("/getBitcoin")
    public BigDecimal getBitcoin() {
        return bitcoinService.getBitcoinPrice();
    }

}
