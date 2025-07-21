package com.sunchips.apiv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    @GetMapping("/token")
    public String token(@AuthenticationPrincipal OAuth2User user) {
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
            "spotify", user.getName());
        return client.getAccessToken().getTokenValue();
    }
}

