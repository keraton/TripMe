package com.github.keraton.client;

import com.github.keraton.model.response.flight.FlightResults;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class FlightSearchClient implements InitializingBean, DisposableBean {

    private static final String FLIGHT_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/flights/affiliate-search";

    private final String apiKey;

    private final RestTemplate restTemplate;


    public FlightSearchClient(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.apiKey = environment.getProperty("apiKey");
    }

    public FlightResults getFlight(String origin,
                            String destination,
                            String departureDate,
                            String returnDate) throws URISyntaxException {

        // Start timer

        URI uri = new URIBuilder(FLIGHT_AFFILIATE_SEARCH)
                                            .addParameter("apikey", apiKey)
                                            .addParameter("origin", origin)
                                            .addParameter("destination", destination)
                                            .addParameter("departure_date", departureDate)
                                            .addParameter("return_date", returnDate)
                                            .build();

        ResponseEntity<FlightResults> forEntity = this.restTemplate.getForEntity(uri, FlightResults.class);

        // End Timer
        // Calculate Timer

        return forEntity.getBody();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("The ApiKey " + apiKey);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean Destroyed");
    }
}
