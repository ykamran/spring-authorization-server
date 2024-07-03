package com.abeetek.web;

import com.abeetek.service.ApiKeyAuthProviderService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * REST controller for retrieving API keys.
 *
 * This controller exposes a `/apikey` endpoint that returns an API key.
 * The endpoint requires authentication using the "apikey-client-authorization-code" OAuth2 client.
 *
 * @author Yahya Kamran.
 */
@RestController
public class ApiKeyAuthProviderController {

    private final ApiKeyAuthProviderService apiKeyAuthProviderService;

    /**
     * Constructor for ApiKeyAuthProviderController.
     *
     * @param apiKeyAuthProviderService The ApiKeyAuthProviderService to use for retrieving API keys.
     */
    public ApiKeyAuthProviderController(ApiKeyAuthProviderService apiKeyAuthProviderService) {
        this.apiKeyAuthProviderService = apiKeyAuthProviderService;
    }

    /**
     * Retrieves an API key from the ApiKeyAuthProviderService.
     *
     * @param authorizedClient The OAuth2AuthorizedClient representing the authenticated user.
     * @return A Mono<String> representing the retrieved API key.
     */
    @GetMapping(value = "/apikey")
    public Mono<String> getApiKey(
      @RegisteredOAuth2AuthorizedClient("apikey-client-authorization-code") OAuth2AuthorizedClient authorizedClient
    ) {
        return apiKeyAuthProviderService.getApiKey(authorizedClient);
    }
}