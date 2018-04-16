
package com.github.keraton.model.response.hotel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelResults {

    @SerializedName("results")
    @Expose
    private List<HotelResult> results = null;

    public List<HotelResult> getResults() {
        return results;
    }

    public void setResults(List<HotelResult> results) {
        this.results = results;
    }

}
