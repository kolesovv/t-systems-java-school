package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;

import java.util.Date;

public class ScheduleModel {
    private Date arrivalTime;
    private Date departureTime;
    private Station station;
    private Train train;

    public ScheduleModel(Date arrivalTime, Date departureTime, Station station, Train train) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.station = station;
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

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
