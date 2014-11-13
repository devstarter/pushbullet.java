package com.pushbullet;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

public class PushbulletClient {
    protected String BASE_URL = "https://api.pushbullet.com/v2";

    @Value("${pushbullet.key}")
    protected String key;

    @Autowired
    protected RestTemplate restTemplate;

    protected <Request, Response> Response post(String context, Request request, Class<Response> responseClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String encodedKey = Base64.encodeBase64String(key.getBytes(StandardCharsets.UTF_8));
        headers.add("Authorization", "Basic " + encodedKey);

        final ResponseEntity<Response> entity = restTemplate.postForEntity(BASE_URL +"/"+context,
                new HttpEntity<Request>(request, headers), responseClass);

        return entity.getBody();
    }


}
