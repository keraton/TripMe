
package com.github.keraton.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightResult {

    @SerializedName("outbound")
    @Expose
    private Bound outbound;
    @SerializedName("inbound")
    @Expose
    private Bound inbound;
    @SerializedName("fare")
    @Expose
    private Fare fare;
    @SerializedName("cabin_code")
    @Expose
    private String cabinCode;
    @SerializedName("fare_family")
    @Expose
    private String fareFamily;
    @SerializedName("travel_class")
    @Expose
    private String travelClass;
    @SerializedName("merchant")
    @Expose
    private String merchant;
    @SerializedName("airline")
    @Expose
    private String airline;
    @SerializedName("deep_link")
    @Expose
    private String deepLink;

    public Bound getOutbound() {
        return outbound;
    }

    public void setOutbound(Bound outbound) {
        this.outbound = outbound;
    }

    public Bound getInbound() {
        return inbound;
    }

    public void setInbound(Bound inbound) {
        this.inbound = inbound;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public String getCabinCode() {
        return cabinCode;
    }

    public void setCabinCode(String cabinCode) {
        this.cabinCode = cabinCode;
    }

    public String getFareFamily() {
        return fareFamily;
    }

    public void setFareFamily(String fareFamily) {
        this.fareFamily = fareFamily;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

}
