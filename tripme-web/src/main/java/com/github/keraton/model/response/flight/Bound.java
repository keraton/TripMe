
package com.github.keraton.model.response.flight;

import java.util.List;

public class Bound {

    private String duration;
    private List<Flight> flights = null;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

}
