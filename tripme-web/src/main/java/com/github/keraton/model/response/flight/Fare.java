
package com.github.keraton.model.response.flight;

public class Fare {

    private String currency;
    private String totalPrice;
    private Restrictions restrictions;
    private PricePerAdult pricePerAdult;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public PricePerAdult getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(PricePerAdult pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

}
