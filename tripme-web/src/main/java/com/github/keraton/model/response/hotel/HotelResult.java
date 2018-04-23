
package com.github.keraton.model.response.hotel;

import java.util.List;

public class HotelResult {

    private String propertyCode;
    private String propertyName;
    private Location location;
    private Address address;
    private TotalPrice totalPrice;
    private MinDailyRate minDailyRate;
    private List<Contact> contacts = null;
    private List<Amenity> amenities = null;
    private List<Object> awards = null;
    private List<Object> images = null;
    private List<Room> rooms = null;
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
