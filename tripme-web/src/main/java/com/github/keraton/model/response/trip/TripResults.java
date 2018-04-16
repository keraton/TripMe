package com.github.keraton.model.response.trip;

import com.github.keraton.model.response.flight.FlightResult;
import com.github.keraton.model.response.hotel.HotelResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripResults {

    @SerializedName("flight")
    @Expose
    private FlightResult flight;

    @SerializedName("hotel")
    @Expose
    private HotelResult hotelResult;

    public FlightResult getFlight() {
        return flight;
    }

    public void setFlight(FlightResult flight) {
        this.flight = flight;
    }

    public HotelResult getHotelResult() {
        return hotelResult;
    }

    public void setHotel(HotelResult hotelResult) {
        this.hotelResult = hotelResult;
    }
}
