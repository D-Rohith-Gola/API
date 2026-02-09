package com.oauthpostputdelete.configuration;


import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String ALLOWED_EMAIL = "rohitgola00@gmail.com";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(HttpMethod.GET, "/api/**")
                    .access(this::allowOnlySpecificEmail)

                .requestMatchers(HttpMethod.POST, "/api/**")
                    .access(this::allowOnlySpecificEmail)

                .requestMatchers(HttpMethod.PUT, "/api/**")
                    .access(this::allowOnlySpecificEmail)

                .requestMatchers(HttpMethod.DELETE, "/api/**")
                    .access(this::allowOnlySpecificEmail)

                .anyRequest().denyAll()
            )

            .oauth2ResourceServer(oauth2 -> oauth2.jwt());

        return http.build();
    }

    private AuthorizationDecision allowOnlySpecificEmail(
            Supplier<Authentication> authentication,
            RequestAuthorizationContext context) {

        Jwt jwt = (Jwt) authentication.get().getPrincipal();
        String email = jwt.getClaimAsString("email");

        return new AuthorizationDecision(ALLOWED_EMAIL.equals(email));
    }
}
