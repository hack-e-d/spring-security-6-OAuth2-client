package com.hacked.springsecurity6oauth2client.Controllers;

import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class DemoController {

    private final OAuth2AuthorizedClientManager auth2AuthorizedClientManager;

    public DemoController(OAuth2AuthorizedClientManager auth2AuthorizedClientManager) {
        this.auth2AuthorizedClientManager = auth2AuthorizedClientManager;
    }

    /*
    * Get token endpoint fetches the bearer token from the authorization server
    * @author vijay pv
    * @return bearer token
    * */
    @GetMapping("/token")
    public String getToken() {

        OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                .withClientRegistrationId("1")
                .principal("client")
                .build();

        OAuth2AuthorizedClient client = this.auth2AuthorizedClientManager.authorize(request);
        return client.getAccessToken().getTokenValue(); // added on the Authorization header on the request with prefix "Bearer..."
    }
}
