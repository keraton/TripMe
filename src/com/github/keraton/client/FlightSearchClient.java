package com.github.keraton.client;

import com.github.keraton.utils.HttpToStringClient;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class FlightSearchClient {

    private static final String FLIGHT_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/flights/affiliate-search";

    private static final String API_KEY = "0DFGZzo4o3n2FTuPl9NfIjNA5zWpZvRs";

    public String getFlight(String origin,
                            String destination,
                            String departureDate,
                            String returnDate) throws URISyntaxException {

        HttpClient httpClient = HttpClientBuilder
                                            .create()
                                            .build();

        URI uri = new URIBuilder(FLIGHT_AFFILIATE_SEARCH)
                                            .addParameter("apikey", API_KEY)
                                            .addParameter("origin", origin)
                                            .addParameter("destination", destination)
                                            .addParameter("departure_date", departureDate)
                                            .addParameter("return_date", returnDate)
                                            .build();

        HttpGet getFlightSearch = new HttpGet(uri);

        String result = HttpToStringClient.execute(httpClient, getFlightSearch);

        return result;
    }


    public static void  main(String... args) throws URISyntaxException {
        FlightSearchClient flightSearchClient = new FlightSearchClient();
        String result = flightSearchClient.getFlight("LON",
                                                    "DUB",
                                                    "2018-06-25",
                                                    "2018-06-27");

        System.out.println("Result : " + result);

    }
}
