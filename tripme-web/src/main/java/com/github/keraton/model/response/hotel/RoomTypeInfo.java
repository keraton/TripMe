
package com.github.keraton.model.response.hotel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomTypeInfo {

    @SerializedName("room_type")
    @Expose
    private String roomType;
    @SerializedName("bed_type")
    @Expose
    private String bedType;
    @SerializedName("number_of_beds")
    @Expose
    private String numberOfBeds;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(String numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

}
