package com.github.keraton.service;

import com.github.keraton.client.HotelSearchClient;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.hotel.HotelResults;
import com.google.gson.Gson;

import java.net.URISyntaxException;

public class HotelSearchService {

    private final HotelSearchClient hotelSearchClient;


    public HotelSearchService() {
        hotelSearchClient = new HotelSearchClient();
    }

    public HotelResults getHotelResults(HotelRequest request) {
        try {
            String hotels = hotelSearchClient.getHotels(request.getLocation(), request.getCheckIn(), request.getCheckOut());

            Gson gson = new Gson();
            HotelResults hotelResults = gson.fromJson(hotels, HotelResults.class);

            // TODO find the cheapest

            return hotelResults;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
