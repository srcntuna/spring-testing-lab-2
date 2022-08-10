package com.example.springTestingLab2.Controllers;

import com.example.springTestingLab2.Configurations.SecurityConfiguration;
import com.example.springTestingLab2.Services.CoinService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class CoinController {


    private CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }


    @GetMapping("/getPrice/{coinName}")
    public BigDecimal getBitcoin(@PathVariable String coinName) {

        log.trace("getting Coin Price");

        log.trace("returning Coin Price");

        return coinService.getCoinPrice(coinName);


    }

}
