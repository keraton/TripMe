
package com.github.keraton.model.response.hotel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("more_rooms_at_this_hotel")
    @Expose
    private MoreRoomsAtThisHotel moreRoomsAtThisHotel;

    public MoreRoomsAtThisHotel getMoreRoomsAtThisHotel() {
        return moreRoomsAtThisHotel;
    }

    public void setMoreRoomsAtThisHotel(MoreRoomsAtThisHotel moreRoomsAtThisHotel) {
        this.moreRoomsAtThisHotel = moreRoomsAtThisHotel;
    }

}
