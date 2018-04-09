package com.github.keraton.handler;

import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.response.FlightResults;
import com.github.keraton.service.FlightSearchService;
import com.github.keraton.utils.HttpQueryUtil;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Search handler for Flight, Train and Hotel
 *
 */
public class TripSearchHandler implements HttpHandler {

    private final FlightSearchService flightSearchService;

    public TripSearchHandler() {
        this.flightSearchService = new FlightSearchService();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getQuery();
        Map<String, String> queryToMap = HttpQueryUtil.queryToMap(query);

        System.out.println("Flight Search with " + query);
        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setOrigin(queryToMap.get("origin"));
        flightRequest.setDestination(queryToMap.get("destination"));
        flightRequest.setDeparture(queryToMap.get("departure"));
        flightRequest.setArrival(queryToMap.get("arrival"));

        FlightResults flightResult = this.flightSearchService.getFlightResult(flightRequest);

        Gson gson = new Gson();
        String response = gson.toJson(flightResult);

        sendRespond(httpExchange, response);
    }

    private void sendRespond(HttpExchange t, String response) throws IOException {
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
