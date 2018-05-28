package com.github.keraton.client;

import com.github.keraton.aop.LoggingTime;
import com.github.keraton.model.response.flight.FlightResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FlightSearchClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightSearchClient.class);

    private final String apiKey;

    private final RestTemplate restTemplate;

    private final String flightUrl;


    public FlightSearchClient(RestTemplate restTemplate, Environment environment,
                              @Value("${flightUrl}") String flightUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = environment.getProperty("apiKey");
        this.flightUrl = flightUrl;
    }

    @LoggingTime
    @Cacheable("flights")
    public FlightResults getFlight(String origin,
                            String destination,
                            String departureDate,
                            String returnDate) {

        LOGGER.info("Flight call");

        // Start timer
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(this.flightUrl)
                                                            .queryParam("apikey", apiKey)
                                                            .queryParam("origin", origin)
                                                            .queryParam("destination", destination)
                                                            .queryParam("departure_date", departureDate)
                                                            .queryParam("return_date", returnDate)
                                                            .build();

        ResponseEntity<FlightResults> forEntity = this.restTemplate.getForEntity(uriComponents.toUri(), FlightResults.class);

        return forEntity.getBody();
    }


}
