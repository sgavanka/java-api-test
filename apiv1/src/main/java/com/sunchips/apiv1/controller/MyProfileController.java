package com.sunchips.apiv1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunchips.apiv1.model.SpotifyUser;

import reactor.core.publisher.Mono;

@RestController
public class MyProfileController {

     @Autowired
     private WebClient webClient;

@GetMapping("/me")
public Mono<ResponseEntity<SpotifyUser>> me() {
    return webClient.get()
        .uri("https://api.spotify.com/v1/me")
        .retrieve()
        .bodyToMono(SpotifyUser.class)
        .map(ResponseEntity::ok);
}



}
