package com.example.farm.alert.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DiscordAlertService implements AlertService {

    @Value("${farm.variable.discordWebHockUrl}")
    private String discordWebHockUrl;

    @Override
    public String sendAlert(String msg) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");

        String body = "{ \"content\" : \"" + msg + "\"}";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                discordWebHockUrl,
                HttpMethod.POST,
                new HttpEntity<>(body, headers),
                String.class
        );
        log.info("Discord Message Send Result(response) {}",response.getBody());

        return "success";
    }
}
