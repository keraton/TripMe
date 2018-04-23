package com.github.keraton.service;

import com.github.keraton.client.HotelSearchClient;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.hotel.HotelResults;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class HotelSearchService {

    private final HotelSearchClient hotelSearchClient;


    public HotelSearchService(HotelSearchClient hotelSearchClient) {
        this.hotelSearchClient = hotelSearchClient;
    }

    public HotelResults getHotelResults(HotelRequest request) {
        try {
            return hotelSearchClient.getHotels(request.getLocation(), request.getCheckIn(), request.getCheckOut());

        } catch (URISyntaxException e) {
            return null;
        }
    }
}
