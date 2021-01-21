package com.t_systems.sbb.dto;

import java.util.Date;

public class ScheduleTrainDTO {

    private String stationName;

    private Date arrivalTime;

    private Date departureTime;

    public ScheduleTrainDTO() {
    }

    public ScheduleTrainDTO(String stationName, Date arrivalTime, Date departureTime) {
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return  "stationName='" + stationName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime;
    }
}
