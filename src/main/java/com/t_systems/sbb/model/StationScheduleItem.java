package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Train;

import java.util.Date;

public class StationScheduleItem {
    private long id;
    private Train train;
    private Date arrivalTime;
    private Date departureTime;

    public StationScheduleItem(long id, Train train, Date arrivalTime, Date departureTime) {
        this.id = id;
        this.train = train;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
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
