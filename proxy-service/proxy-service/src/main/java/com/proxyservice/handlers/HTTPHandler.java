/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proxyservice.handlers;

import com.proxyservice.controllers.models.TokenProxyRequest;
import com.proxyservice.controllers.models.TokenProxyResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Mostafa Kashif
 */
@Component
public class HTTPHandler {

    @Value("${keycloak.token.url}")
    private String keycloaktokenURL;

    public TokenProxyResponse retrieveKeyCloakToken(TokenProxyRequest tokenProxyRequest) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", tokenProxyRequest.getGrant_type());
        map.add("client_id", tokenProxyRequest.getClient_id());
        map.add("username", tokenProxyRequest.getUsername());
        map.add("password", tokenProxyRequest.getPassword());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<TokenProxyResponse> response = restTemplate.postForEntity(
                keycloaktokenURL, request, TokenProxyResponse.class);
        return response.getBody();
    }
}
