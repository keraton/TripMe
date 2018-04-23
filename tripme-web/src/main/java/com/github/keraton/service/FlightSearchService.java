package com.github.keraton.service;

import com.github.keraton.client.FlightSearchClient;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.response.flight.FlightResults;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class FlightSearchService {

    private final FlightSearchClient flightSearchClient;

    public FlightSearchService(FlightSearchClient flightSearchClient) {
        this.flightSearchClient = flightSearchClient;
    }

    public FlightResults getFlightResult(FlightRequest flightRequest) {
        try {
            return flightSearchClient.getFlight(flightRequest.getOrigin(),
                                                        flightRequest.getDestination(),
                                                        flightRequest.getDeparture(),
                                                        flightRequest.getArrival());

        } catch (Exception e) {
            return null;
        }
    }

}
