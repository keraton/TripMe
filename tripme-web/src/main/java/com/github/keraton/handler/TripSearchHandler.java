package com.github.keraton.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.keraton.aop.LoggingTime;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.flight.FlightResults;
import com.github.keraton.model.response.hotel.HotelResults;
import com.github.keraton.model.response.trip.TripResults;
import com.github.keraton.service.FlightSearchService;
import com.github.keraton.service.HotelSearchService;
import com.github.keraton.service.TripService;
import com.github.keraton.utils.HttpQueryUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.springframework.stereotype.Component;

import javax.inject.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Search handler for Flight, Train and Hotel
 *
 */
@Component
public class TripSearchHandler implements HttpHandler{


    private final TripService tripService;
    private final ObjectMapper mapper;
    private final Provider<FlightRequest> flightRequestProvider;

    public TripSearchHandler(HotelSearchService hotelSearchService,
                             FlightSearchService flightSearchService, TripService tripService, ObjectMapper mapper,
                             Provider<FlightRequest> flightRequestProvider) {
        this.tripService = tripService;
        this.mapper = mapper;
        this.flightRequestProvider = flightRequestProvider;
    }



    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getQuery();
        Map<String, String> queryToMap = HttpQueryUtil.queryToMap(query);

        System.out.println("Trip Search with " + query);

        //FlightRequest flightRequest = this.applicationContext.getBean(FlightRequest.class);
        FlightRequest flightRequest = flightRequestProvider.get();
        System.out.println(flightRequest.hashCode());

        flightRequest.setOrigin(queryToMap.get("origin"));
        flightRequest.setDestination(queryToMap.get("destination"));
        flightRequest.setDeparture(queryToMap.get("departure"));
        flightRequest.setArrival(queryToMap.get("arrival"));


        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setLocation(queryToMap.get("destination"));
        hotelRequest.setCheckIn(queryToMap.get("departure"));
        hotelRequest.setCheckOut(queryToMap.get("arrival"));


        TripResults tripResults = tripService.getTripResults(flightRequest, hotelRequest);


        String value = mapper.writeValueAsString(tripResults);

        sendRespond(httpExchange, value);

    }

    private void sendRespond(HttpExchange t, String response) throws IOException {
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
