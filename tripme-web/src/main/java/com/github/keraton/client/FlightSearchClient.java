package com.github.keraton.client;

import com.github.keraton.aop.LoggingTime;
import com.github.keraton.model.response.flight.FlightResults;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FlightSearchClient {

    private static final String FLIGHT_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/flights/affiliate-search";

    private final String apiKey;

    private final RestTemplate restTemplate;


    public FlightSearchClient(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.apiKey = environment.getProperty("apiKey");
    }

    @LoggingTime
    public FlightResults getFlight(String origin,
                            String destination,
                            String departureDate,
                            String returnDate) {

        // Start timer
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(FLIGHT_AFFILIATE_SEARCH)
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
