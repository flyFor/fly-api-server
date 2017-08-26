package com.github.flyfor.model;

/**
 * Created on 2017. 8. 26..
 */
public class SearchParameter {

    String CarCode;
    String Itinerary;
    String DepCity;
    String ArrCity;
    long DepDate;
    long ArrDate;
    String SeatClass;
    long ACnt;
    long CCnt;
    long ICnt;
    String Where;

    public String getCarCode() {
        return CarCode;
    }

    public void setCarCode(String carCode) {
        CarCode = carCode;
    }

    public String getItinerary() {
        return Itinerary;
    }

    public void setItinerary(String itinerary) {
        Itinerary = itinerary;
    }

    public String getDepCity() {
        return DepCity;
    }

    public void setDepCity(String depCity) {
        DepCity = depCity;
    }

    public String getArrCity() {
        return ArrCity;
    }

    public void setArrCity(String arrCity) {
        ArrCity = arrCity;
    }

    public long getDepDate() {
        return DepDate;
    }

    public void setDepDate(long depDate) {
        DepDate = depDate;
    }

    public long getArrDate() {
        return ArrDate;
    }

    public void setArrDate(long arrDate) {
        ArrDate = arrDate;
    }

    public String getSeatClass() {
        return SeatClass;
    }

    public void setSeatClass(String seatClass) {
        SeatClass = seatClass;
    }

    public long getACnt() {
        return ACnt;
    }

    public void setACnt(long ACnt) {
        this.ACnt = ACnt;
    }

    public long getCCnt() {
        return CCnt;
    }

    public void setCCnt(long CCnt) {
        this.CCnt = CCnt;
    }

    public long getICnt() {
        return ICnt;
    }

    public void setICnt(long ICnt) {
        this.ICnt = ICnt;
    }

    public String getWhere() {
        return Where;
    }

    public void setWhere(String where) {
        Where = where;
    }
}
