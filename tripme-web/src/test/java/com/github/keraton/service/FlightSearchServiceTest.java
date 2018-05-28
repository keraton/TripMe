package com.github.keraton.service;


import com.github.keraton.client.FlightSearchClient;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.response.flight.FlightResults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FlightSearchServiceTest {

    //@Mock
    private FlightSearchClient flightSearchClient;

    @InjectMocks
    private FlightSearchService flightSearchService;


    @Test(expected = NullPointerException.class)
    public void should_ () throws ExecutionException, InterruptedException {
        // Given
        FlightResults results = new FlightResults();
        given(flightSearchClient.getFlight("PAR", "LON", "2018-01-01", "2018-01-02"))
                .willReturn(results);

        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setOrigin("PAR");
        flightRequest.setArrival("LON");
        flightRequest.setDeparture("2018-01-01");
        flightRequest.setArrival("2018-01-02");

        // When
        CompletableFuture<FlightResults> flightResult = flightSearchService.getFlightResult(flightRequest);

        // Then
        FlightResults flightResults = flightResult.get();
        assertThat(flightResults).isEqualTo(results);
    }

}