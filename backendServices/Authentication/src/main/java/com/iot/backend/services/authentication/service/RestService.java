package com.iot.backend.services.authentication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public class RestService {
    private final RestTemplate restTemplate;


    public RestService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public ResponseEntity<String> createGetRequest(String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-origin", "Master");
        HttpEntity<?> request = new HttpEntity<>(headers);
        return this.restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
    }

    public ResponseEntity<String> createPostRequest(String uri, Map<String, Object> payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-origin", "Master");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(payload, headers);
        return this.restTemplate.postForEntity(uri, request, String.class);
    }

    public ResponseEntity<String> createPutRequest(String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-origin", "Master");
        HttpEntity<?> request = new HttpEntity<>(headers);
        return this.restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
    }

    public ResponseEntity<String> createDeleteRequest(String uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-origin", "Master");
        HttpEntity<?> request = new HttpEntity<>(headers);
        return this.restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
    }

    public ResponseEntity<String> createRingRequest(Map<String, Object> payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = this.restTemplate.exchange("http://192.168.43.252/iotController/medicine", HttpMethod.POST, request, String.class);
        log.debug(String.valueOf(response.getStatusCode()));
        return response;
    }
}
