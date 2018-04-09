
package com.github.keraton.model.response.hotel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amenity {

    @SerializedName("amenity")
    @Expose
    private String amenity;
    @SerializedName("ota_code")
    @Expose
    private Integer otaCode;
    @SerializedName("description")
    @Expose
    private String description;

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public Integer getOtaCode() {
        return otaCode;
    }

    public void setOtaCode(Integer otaCode) {
        this.otaCode = otaCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
