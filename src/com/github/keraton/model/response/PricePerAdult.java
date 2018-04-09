
package com.github.keraton.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PricePerAdult {

    @SerializedName("tax")
    @Expose
    private String tax;
    @SerializedName("total_fare")
    @Expose
    private String totalFare;

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

}
