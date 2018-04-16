
package com.github.keraton.model.response.flight;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightResults {

    @SerializedName("results")
    @Expose
    private List<FlightResult> results = null;

    public List<FlightResult> getResults() {
        return results;
    }

    public void setResults(List<FlightResult> results) {
        this.results = results;
    }

}
