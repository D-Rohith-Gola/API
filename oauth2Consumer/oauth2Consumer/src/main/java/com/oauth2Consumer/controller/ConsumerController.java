package com.oauth2Consumer.controller;

import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders authHeaders(OAuth2AuthorizedClient client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(client.getAccessToken().getTokenValue());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    // ✅ GET
    @GetMapping("/call-producer/get")
    public String get(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client) {

        HttpEntity<String> entity = new HttpEntity<>(authHeaders(client));

        return restTemplate.exchange(
                "http://localhost:8086/api/data",
                HttpMethod.GET,
                entity,
                String.class
        ).getBody();
    }

    // ✅ POST
    @PostMapping("/call-producer/post")
    public String post(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client) {

        HttpEntity<String> entity = new HttpEntity<>("{\"msg\":\"hello\"}", authHeaders(client));

        return restTemplate.exchange(
                "http://localhost:8086/api/data",
                HttpMethod.POST,
                entity,
                String.class
        ).getBody();
    }

    // ✅ PUT
    @PutMapping("/call-producer/put")
    public String put(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client) {

        HttpEntity<String> entity = new HttpEntity<>("{\"msg\":\"update\"}", authHeaders(client));

        return restTemplate.exchange(
                "http://localhost:8086/api/data",
                HttpMethod.PUT,
                entity,
                String.class
        ).getBody();
    }

    // ✅ DELETE
    @DeleteMapping("/call-producer/delete")
    public String delete(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client) {

        HttpEntity<String> entity = new HttpEntity<>(authHeaders(client));

        return restTemplate.exchange(
                "http://localhost:8086/api/data",
                HttpMethod.DELETE,
                entity,
                String.class
        ).getBody();
    }
}
