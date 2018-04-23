package com.github.keraton.client;

import com.github.keraton.model.response.flight.FlightResults;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class FlightSearchClient {

    private static final String FLIGHT_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/flights/affiliate-search";

    private static final String API_KEY = "0DFGZzo4o3n2FTuPl9NfIjNA5zWpZvRs";

    private final RestTemplate restTemplate;

    public FlightSearchClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FlightResults getFlight(String origin,
                            String destination,
                            String departureDate,
                            String returnDate) throws URISyntaxException {

        URI uri = new URIBuilder(FLIGHT_AFFILIATE_SEARCH)
                                            .addParameter("apikey", API_KEY)
                                            .addParameter("origin", origin)
                                            .addParameter("destination", destination)
                                            .addParameter("departure_date", departureDate)
                                            .addParameter("return_date", returnDate)
                                            .build();

        ResponseEntity<FlightResults> forEntity = this.restTemplate.getForEntity(uri, FlightResults.class);

        return forEntity.getBody();
    }


}
