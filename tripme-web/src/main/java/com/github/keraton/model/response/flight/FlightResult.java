
package com.github.keraton.model.response.flight;

public class FlightResult {

    private Bound outbound;
    private Bound inbound;
    private Fare fare;
    private String cabinCode;
    private String fareFamily;
    private String travelClass;
    private String merchant;
    private String airline;
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
