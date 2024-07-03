package com.abeetek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Security Configuration class for setting up Spring Security.
 * This class configures the security settings for the application,
 * including OAuth2 login and client settings.
 */
@EnableWebSecurity
public class SecurityConfig {

    /**
     * This method defines and configures the security filter chain for the application.
     *
     * @param http the {@link HttpSecurity} to use for configuring security.
     * @return a {@link SecurityFilterChain} that defines the security configuration.
     * @throws Exception if an error occurs while configuring security.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests.anyRequest().authenticated()
          )
          .oauth2Login(oauth2Login ->
            oauth2Login.loginPage("/oauth2/authorization/apikey-client-oidc"))
          .oauth2Client(withDefaults());
        return http.build();
    }
}