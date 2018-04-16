
package com.github.keraton.model.response.hotel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelResult {

    @SerializedName("property_code")
    @Expose
    private String propertyCode;
    @SerializedName("property_name")
    @Expose
    private String propertyName;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("total_price")
    @Expose
    private TotalPrice totalPrice;
    @SerializedName("min_daily_rate")
    @Expose
    private MinDailyRate minDailyRate;
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;
    @SerializedName("amenities")
    @Expose
    private List<Amenity> amenities = null;
    @SerializedName("awards")
    @Expose
    private List<Object> awards = null;
    @SerializedName("images")
    @Expose
    private List<Object> images = null;
    @SerializedName("rooms")
    @Expose
    private List<Room> rooms = null;
    @SerializedName("_links")
    @Expose
    private Links links;

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(TotalPrice totalPrice) {
        this.totalPrice = totalPrice;
    }

    public MinDailyRate getMinDailyRate() {
        return minDailyRate;
    }

    public void setMinDailyRate(MinDailyRate minDailyRate) {
        this.minDailyRate = minDailyRate;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public List<Object> getAwards() {
        return awards;
    }

    public void setAwards(List<Object> awards) {
        this.awards = awards;
    }

    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
