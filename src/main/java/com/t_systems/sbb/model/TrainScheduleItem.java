package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Station;

import java.util.Date;

public class TrainScheduleItem{
    private long id;
    private Station station;
    private Date arrivalTime;
    private Date departureTime;

    public TrainScheduleItem(long id, Station station, Date arrivalTime, Date departureTime) {
        this.id = id;
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
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
}
