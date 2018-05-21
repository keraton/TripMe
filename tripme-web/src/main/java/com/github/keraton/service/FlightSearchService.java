package com.github.keraton.service;

import com.github.keraton.client.FlightSearchClient;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.response.flight.FlightResults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class FlightSearchService {

    private final FlightSearchClient flightSearchClient;

    public FlightSearchService(FlightSearchClient flightSearchClient) {
        this.flightSearchClient = flightSearchClient;
    }

    @Async
    public CompletableFuture<FlightResults> getFlightResult(FlightRequest flightRequest) {


        try {
            FlightResults flight = flightSearchClient.getFlight(flightRequest.getOrigin(),
                    flightRequest.getDestination(),
                    flightRequest.getDeparture(),
                    flightRequest.getArrival());
            return CompletableFuture.completedFuture(flight);

        } catch (Exception e) {
            return null;
        }
    }


}
