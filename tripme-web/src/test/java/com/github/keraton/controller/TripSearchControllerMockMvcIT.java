package com.github.keraton.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class TripSearchControllerMockMvcIT {

    @ClassRule
    public static WireMockRule wireMockRule = new WireMockRule(9997);

    @Autowired
    private MockMvc mvc;

    @Before
    public void init () {
        wireMockRule.stubFor(
                get("/flight?apikey=1234&origin=LON&destination=DUB&departure_date=2018-06-01&return_date=2018-06-02")
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBodyFile("wiremock/flight/flightResult.json")
                    )
        );

        wireMockRule.stubFor(get("/hotel?apikey=1234&location=DUB&check_in=2018-06-01&check_out=2018-06-02")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("wiremock/hotel/hotelResult.json")
                )
        );

    }

    @Test
    public void should () throws Exception {
        // Given

        ResultActions resultAccounts = mvc.perform(MockMvcRequestBuilders.get("/trips?origin=LON&destination=DUB&departure=2018-06-01&arrival=2018-06-02")
                                            .accept(MediaType.APPLICATION_JSON));


        // Then
        resultAccounts.andExpect(status().isOk())
                .andExpect(jsonPath("$.hotel_result").isNotEmpty())
                .andExpect(jsonPath("$.hotel_result.property_code").value("PIDUBAWQ"))
                .andDo(print());
    }

}