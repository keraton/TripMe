package com.github.keraton.service;

import com.github.keraton.client.FlightSearchClient;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.response.flight.FlightResults;
import com.google.gson.Gson;

import java.net.URISyntaxException;

public class FlightSearchService {

    private final FlightSearchClient flightSearchClient;

    public FlightSearchService() {
        this.flightSearchClient = new FlightSearchClient();
    }

    public FlightResults getFlightResult(FlightRequest flightRequest) {
        try {
            String result = flightSearchClient.getFlight(flightRequest.getOrigin(),
                                                        flightRequest.getDestination(),
                                                        flightRequest.getDeparture(),
                                                        flightRequest.getArrival());

            Gson gson = new Gson();
            FlightResults flightResult = gson.fromJson(result, FlightResults.class);

            // TODO find the cheapest

            return flightResult;

        } catch (URISyntaxException e) {
            return null;
        }
    }


    public static void  main(String... args) {
        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setOrigin("LON");
        flightRequest.setDestination("DUB");
        flightRequest.setDeparture("2018-06-01");
        flightRequest.setArrival("2018-06-02");

        FlightSearchService flightSearchService = new FlightSearchService();
        FlightResults flightResult = flightSearchService.getFlightResult(flightRequest);

        System.out.println(flightResult);

    }

}
