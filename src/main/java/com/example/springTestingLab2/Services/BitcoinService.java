package com.example.springTestingLab2.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class BitcoinService {

    public BigDecimal getBitcoinPrice() {
        String apiURL = "https://api.coincap.io/v2/assets/bitcoin/";
        RestTemplate restTemplate = new RestTemplate();
        Data data = restTemplate.getForObject(apiURL, Data.class);

        assert data != null;
        return data.data.priceUsd;

    }
}
