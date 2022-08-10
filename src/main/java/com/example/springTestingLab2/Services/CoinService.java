package com.example.springTestingLab2.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@Slf4j
public class CoinService {

    public BigDecimal getCoinPrice(@RequestParam(name = "targetName", defaultValue = "bitcoin") String coin) {

        log.trace("in Bitcoin Service");

        String baseApiURl = "https://api.coincap.io/v2/assets/";
        String completeApiUrl = baseApiURl + coin;

        RestTemplate restTemplate = new RestTemplate();
        log.info("fetching the coin price");
        Data data = restTemplate.getForObject(completeApiUrl, Data.class);
        assert data != null;
        log.info("fetched the price of " + data.data.name + " from api....");

        log.trace("leaving getCoinPrice method...");

        return data.data.priceUsd;

    }
}
