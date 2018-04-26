package com.github.keraton.client;

import com.github.keraton.model.response.hotel.HotelResults;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class HotelSearchClient {

    private static final String HOTEL_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/hotels/search-airport";

    private static final String API_KEY = "CHANGE-WITH-REAL-ONE";

    private final RestTemplate restTemplate;

    public HotelSearchClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HotelResults getHotels(String location,
                                  String departureDate,
                                  String returnDate) throws URISyntaxException {

        URI uri = new URIBuilder(HOTEL_AFFILIATE_SEARCH)
                                            .addParameter("apikey", API_KEY)
                                            .addParameter("location", location)
                                            .addParameter("check_in", departureDate)
                                            .addParameter("check_out", returnDate)
                                            .build();


        ResponseEntity<HotelResults> forEntity = restTemplate.getForEntity(uri, HotelResults.class);

        return forEntity.getBody();
    }
}
