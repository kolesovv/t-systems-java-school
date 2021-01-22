package com.t_systems.sbb.dto;

import java.util.Date;

public class ScheduleStationDTO {
    private String trainName;
    private Date departure;
    private Date arrival;

    public ScheduleStationDTO() {
    }

    public ScheduleStationDTO(String trainName, Date departure, Date arrival) {
        this.trainName = trainName;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "Train: " +
                trainName +
                " Departure: " + departure +
                " Arrival: " + arrival;
    }
}
