package com.abeetek.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

/**
 * Service responsible for retrieving API keys from an external API.
 *
 * This service uses a WebClient to make a GET request to the configured API endpoint.
 * The request is authenticated using the provided OAuth2AuthorizedClient.
 *
 * @author Yahya Kamran
 */
@Service
public class ApiKeyAuthProviderService {
    private final WebClient webClient;
    private final String apiKeyEndPoint;

    /**
     * Constructor for ApiKeyAuthProviderService.
     *
     * @param webClient The WebClient to use for making API requests.
     * @param apiKeyEndPoint The URL of the API endpoint for retrieving API keys.
     */
    public ApiKeyAuthProviderService(WebClient webClient, @Value("${api.key.endpoint}") String apiKeyEndPoint) {
        this.webClient = webClient;
        this.apiKeyEndPoint = apiKeyEndPoint;
    }

    /**
     * Retrieves an API key from the configured API endpoint.
     *
     * @param authorizedClient The OAuth2AuthorizedClient to use for authentication.
     * @return A Mono<String> representing the retrieved API key.
     *         If an error occurs during the API call, a Mono containing an error message will be returned.
     */
    public Mono<String> getApiKey(OAuth2AuthorizedClient authorizedClient) {
        return webClient.get()
                .uri(apiKeyEndPoint)
                .attributes(oauth2AuthorizedClient(authorizedClient))
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(exp -> Mono.just("Failed to retrieve the API key: " + exp.getMessage()));
    }
}
