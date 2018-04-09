
package com.github.keraton.model.response.hotel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Room {

    @SerializedName("booking_code")
    @Expose
    private String bookingCode;
    @SerializedName("room_type_code")
    @Expose
    private String roomTypeCode;
    @SerializedName("rate_plan_code")
    @Expose
    private String ratePlanCode;
    @SerializedName("total_amount")
    @Expose
    private TotalAmount totalAmount;
    @SerializedName("rates")
    @Expose
    private List<Rate> rates = null;
    @SerializedName("descriptions")
    @Expose
    private List<String> descriptions = null;
    @SerializedName("room_type_info")
    @Expose
    private RoomTypeInfo roomTypeInfo;
    @SerializedName("rate_type_code")
    @Expose
    private String rateTypeCode;

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public TotalAmount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(TotalAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public RoomTypeInfo getRoomTypeInfo() {
        return roomTypeInfo;
    }

    public void setRoomTypeInfo(RoomTypeInfo roomTypeInfo) {
        this.roomTypeInfo = roomTypeInfo;
    }

    public String getRateTypeCode() {
        return rateTypeCode;
    }

    public void setRateTypeCode(String rateTypeCode) {
        this.rateTypeCode = rateTypeCode;
    }

}
