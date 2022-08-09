package com.example.springTestingLab2.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class BitcoinService {

    public BigDecimal getBitcoinPrice(@RequestParam(name = "targetName", defaultValue = "bitcoin") String coin) {

        String baseApiURl = "https://api.coincap.io/v2/assets/";
        String completeApiUrl = baseApiURl + coin;

        RestTemplate restTemplate = new RestTemplate();
        Data data = restTemplate.getForObject(completeApiUrl, Data.class);
        assert data != null;
        return data.data.priceUsd;

    }
}
