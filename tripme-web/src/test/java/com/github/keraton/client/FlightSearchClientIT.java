package com.github.keraton.client;

import com.github.keraton.configuration.TripmeConfig;
import com.github.keraton.model.response.flight.FlightResults;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FlightSearchClientIT.TestConfiguration.class)
@TestPropertySource("classpath:application-test.properties")
public class FlightSearchClientIT {

    @ClassRule
    public static WireMockRule wireMockRule = new WireMockRule(9997);

    @Autowired
    private FlightSearchClient flightSearchClient;

    @Test
    public void should () {
        // Given
        wireMockRule.stubFor(get("/flight?apikey=1234&origin=PAR&destination=LON&departure_date=2018-01-01&return_date=2018-01-02")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("wiremock/flight/flightResult.json")
                )
        );

        // When
        FlightResults flight = flightSearchClient.getFlight("PAR", "LON", "2018-01-01", "2018-01-02");

        // Then
        Assertions.assertThat(flight).isNotNull();
    }

    @Configuration
    @Import(TripmeConfig.class)
    static class TestConfiguration {

        @Bean
        FlightSearchClient flightSearchClient(RestTemplate restTemplate, Environment environment) {
            return new FlightSearchClient(restTemplate, environment, "http://localhost:9997flight");
        }


    }
}