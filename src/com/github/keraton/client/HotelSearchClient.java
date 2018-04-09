package com.github.keraton.client;

import com.github.keraton.utils.HttpToStringClient;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class HotelSearchClient {

    private static final String FLIGHT_AFFILIATE_SEARCH =
            "https://api.sandbox.amadeus.com/v1.2/hotels/search-airport";

    private static final String API_KEY = "1FOp7CUKzr04JBIzRl5Weol08aqD7sfn";

    public String getHotels(String location,
                            String departureDate,
                            String returnDate) throws URISyntaxException {

        HttpClient httpClient = HttpClientBuilder
                                            .create()
                                            .build();

        URI uri = new URIBuilder(FLIGHT_AFFILIATE_SEARCH)
                                            .addParameter("apikey", API_KEY)
                                            .addParameter("location", location)
                                            .addParameter("check_in", departureDate)
                                            .addParameter("check_out", returnDate)
                                            .build();

        HttpGet getHotelSearch = new HttpGet(uri);

        String result = HttpToStringClient.execute(httpClient, getHotelSearch);

        return result;
    }


    public static void  main(String... args) throws URISyntaxException {
        HotelSearchClient hotelSearchClient = new HotelSearchClient();
        String result = hotelSearchClient.getHotels("DUB",
                                                    "2018-06-25",
                                                    "2018-06-27");

        System.out.println("Result : " + result);

    }
}
