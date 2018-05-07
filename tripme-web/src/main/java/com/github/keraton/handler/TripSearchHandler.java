package com.github.keraton.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.keraton.model.request.FlightRequest;
import com.github.keraton.model.request.HotelRequest;
import com.github.keraton.model.response.flight.FlightResults;
import com.github.keraton.model.response.hotel.HotelResults;
import com.github.keraton.model.response.trip.TripResults;
import com.github.keraton.service.FlightSearchService;
import com.github.keraton.service.HotelSearchService;
import com.github.keraton.utils.HttpQueryUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import javax.inject.Provider;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Search handler for Flight, Train and Hotel
 *
 */
@Component
public class TripSearchHandler implements HttpHandler, ApplicationContextAware {

    private final FlightSearchService flightSearchService;
    private final HotelSearchService hotelSearchService;
    private final ObjectMapper mapper;
    private ApplicationContext applicationContext;
    private final Provider<FlightRequest> flightRequestProvider;

    public TripSearchHandler(HotelSearchService hotelSearchService,
                             FlightSearchService flightSearchService, ObjectMapper mapper,
                             Provider<FlightRequest> flightRequestProvider) {
        this.flightSearchService = flightSearchService;
        this.hotelSearchService = hotelSearchService;
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

        FlightResults flightResult = this.flightSearchService.getFlightResult(flightRequest);

        HotelRequest hotelRequest = new HotelRequest();
        hotelRequest.setLocation(queryToMap.get("destination"));
        hotelRequest.setCheckIn(queryToMap.get("departure"));
        hotelRequest.setCheckOut(queryToMap.get("arrival"));

        HotelResults hotelResults = this.hotelSearchService.getHotelResults(hotelRequest);

        TripResults tripResults = new TripResults();
        tripResults.setFlight(flightResult.getResults().get(0));
        tripResults.setHotel(hotelResults.getResults().get(0));

        String value = mapper.writeValueAsString(tripResults);

        sendRespond(httpExchange, value);
    }

    private void sendRespond(HttpExchange t, String response) throws IOException {
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
