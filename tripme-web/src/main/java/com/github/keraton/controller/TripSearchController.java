package com.github.keraton.controller;

import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.trip.TripResults;
import com.github.keraton.service.TripService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TripSearchController {

    private final TripService tripService;

    public TripSearchController(TripService tripService) {
        this.tripService = tripService;
    }

    @RequestMapping("trips")
    public TripResults trips(String origin, String destination, String departure, String arrival) {
         FlightRequest flightRequest = new FlightRequest();
         flightRequest.setOrigin(origin);
         flightRequest.setDestination(destination);
         flightRequest.setDeparture(departure);
         flightRequest.setArrival(arrival);

         HotelRequest hotelRequest = new HotelRequest();
         hotelRequest.setLocation(destination);
         hotelRequest.setCheckIn(departure);
         hotelRequest.setCheckOut(arrival);

        return tripService.getTripResults(flightRequest, hotelRequest);
    }
}
