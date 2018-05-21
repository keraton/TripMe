package com.github.keraton.client;

import com.github.keraton.aop.LoggingTime;
import com.github.keraton.model.response.hotel.HotelResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class HotelSearchClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelSearchClient.class);

    private static final String HOTEL_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/hotels/search-airport";

    private final String apiKey;

    private final RestTemplate restTemplate;

    public HotelSearchClient(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        apiKey = environment.getProperty("apiKey");
    }

    @LoggingTime
    @Cacheable("Hotel")
    public HotelResults getHotels(String location,
                                  String departureDate,
                                  String returnDate) {

        LOGGER.info("Hotel call");


        // Start timer
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(HOTEL_AFFILIATE_SEARCH)
                                            .queryParam("apikey", apiKey)
                                            .queryParam("location", location)
                                            .queryParam("check_in", departureDate)
                                            .queryParam("check_out", returnDate)
                                            .build();

        ResponseEntity<HotelResults> forEntity = restTemplate.getForEntity(uriComponents.toUri(), HotelResults.class);

        return forEntity.getBody();
    }
}
