package com.github.keraton.service;

import com.github.keraton.client.HotelSearchClient;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.hotel.HotelResults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class HotelSearchService {

    private final HotelSearchClient hotelSearchClient;


    public HotelSearchService(HotelSearchClient hotelSearchClient) {
        this.hotelSearchClient = hotelSearchClient;
    }

    @Async
    public CompletableFuture<HotelResults> getHotelResults(HotelRequest request) {
        try {
            HotelResults hotels = hotelSearchClient.getHotels(request.getLocation(), request.getCheckIn(), request.getCheckOut());
            return CompletableFuture.completedFuture(hotels);

        } catch (URISyntaxException e) {
            return null;
        }
    }
}
