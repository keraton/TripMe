package com.github.keraton.client;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class FlightSearchClient {

    private static final String FLIGHT_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/flights/affiliate-search";

    private static final String API_KEY = "1FOp7CUKzr04JBIzRl5Weol08aqD7sfn";

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

        String result = "";
        try {
            HttpResponse response = httpClient.execute(getFlightSearch);

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                Scanner s = new Scanner(response.getEntity()
                                        .getContent())
                                        .useDelimiter("\\A");
                result = s.hasNext() ? s.next() : "";
            }
            else {
                System.err.println(response.getStatusLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getFlightSearch.releaseConnection();
        }

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
