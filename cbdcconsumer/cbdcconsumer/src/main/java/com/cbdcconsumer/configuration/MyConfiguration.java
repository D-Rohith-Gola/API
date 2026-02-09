package com.cbdcconsumer.configuration;

/*
import java.io.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {
	
	@Bean
	 @LoadBalanced
	 public RestTemplate restTemplate(){
	  return new RestTemplate();
	 }

}*/

import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import java.net.http.HttpClient;

@Configuration
public class MyConfiguration {

    @Value("${ssl.key-store}")
    private Resource keyStore;

    @Value("${ssl.key-store-password}")
    private String keyStorePassword;

    @Value("${ssl.trust-store}")
    private Resource trustStore;

    @Value("${ssl.trust-store-password}")
    private String trustStorePassword;

    @Bean
    public RestTemplate restTemplate() throws Exception {

        // ---------- Load KeyStore (for mTLS; optional for one-way SSL)
        KeyStore ks = KeyStore.getInstance("PKCS12");
        try (InputStream is = keyStore.getInputStream()) {
            ks.load(is, keyStorePassword.toCharArray());
        }

        KeyManagerFactory kmf =
            KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, keyStorePassword.toCharArray());

        // ---------- Load TrustStore
        KeyStore ts = KeyStore.getInstance(KeyStore.getDefaultType());
        try (InputStream is = trustStore.getInputStream()) {
            ts.load(is, trustStorePassword.toCharArray());
        }

        TrustManagerFactory tmf =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ts);

        // ---------- Build SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(
            kmf.getKeyManagers(),
            tmf.getTrustManagers(),
            null
        );

        // ---------- JDK HttpClient (SSL IS SET HERE)
        HttpClient httpClient = HttpClient.newBuilder()
            .sslContext(sslContext)
            .build();

        // ---------- Spring Factory
        JdkClientHttpRequestFactory factory =
            new JdkClientHttpRequestFactory(httpClient);

        return new RestTemplate(factory);
    }
}
