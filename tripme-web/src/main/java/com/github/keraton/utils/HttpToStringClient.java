package com.github.keraton.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Scanner;

public class HttpToStringClient {
    

    public static String execute(HttpClient httpClient, HttpGet getHotelSearch) {
        String result = "";
        try {
            HttpResponse response = httpClient.execute(getHotelSearch);

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                Scanner s = new Scanner(response.getEntity()
                        .getContent())
                        .useDelimiter("\\A");
                result = s.hasNext() ? s.next() : "";
            }
            else {
                System.err.println("Error during call " + response.getStatusLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getHotelSearch.releaseConnection();
        }
        return result;
    }
}
