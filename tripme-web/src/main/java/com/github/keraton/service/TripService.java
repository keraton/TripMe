package com.github.keraton.service;

import com.github.keraton.aop.LoggingTime;
import com.github.keraton.configuration.ConfigContextHolder;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.flight.FlightResults;
import com.github.keraton.model.response.hotel.HotelResults;
import com.github.keraton.model.response.trip.TripResults;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class TripService {

    private final FlightSearchService flightSearchService;
    private final HotelSearchService hotelSearchService;

    public TripService(FlightSearchService flightSearchService, HotelSearchService hotelSearchService) {
        this.flightSearchService = flightSearchService;
        this.hotelSearchService = hotelSearchService;
    }

    int i = 0;

    @LoggingTime
    public TripResults getTripResults(FlightRequest flightRequest, HotelRequest hotelRequest) {

        ConfigContextHolder.addStripingParameter("key", "value " + i++);


        CompletableFuture<FlightResults> flightResultFuture = this.flightSearchService.getFlightResult(flightRequest);

        CompletableFuture<HotelResults> hotelResultsFuture = this.hotelSearchService.getHotelResults(hotelRequest);

        try {
            Void aVoid = CompletableFuture.allOf(flightResultFuture, hotelResultsFuture).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        try {
            FlightResults flightResults = flightResultFuture.get();
            HotelResults hotelResults = hotelResultsFuture.get();

            TripResults tripResults = new TripResults();
            tripResults.setFlight(flightResults.getResults().get(0));
            tripResults.setHotel(hotelResults.getResults().get(0));

            System.out.println("TripService " + ConfigContextHolder.getStripingParameters().get("key"));

            return tripResults;


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return null;
    }
}
