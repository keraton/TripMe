package com.github.keraton.service;

import com.github.keraton.client.FlightSearchClient;
import com.github.keraton.configuration.ConfigContextHolder;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.response.flight.FlightResults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class FlightSearchService {

    private final FlightSearchClient flightSearchClient;

    public FlightSearchService(FlightSearchClient flightSearchClient) {
        this.flightSearchClient = flightSearchClient;
    }

    @Async
    public CompletableFuture<FlightResults> getFlightResult(FlightRequest flightRequest) {

        System.out.println("FlightSearchService " + ConfigContextHolder.getStripingParameters().get("key"));

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
