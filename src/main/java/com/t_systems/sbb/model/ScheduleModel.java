package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;

import java.util.Date;

public class ScheduleModel {
    private Date arrivalTime;
    private Date departureTime;
    private Station stationArrival;
    private Station stationDeparture;

    public ScheduleModel(Date arrivalTime, Date departureTime, Station stationArrival, Station stationDeparture) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stationArrival = stationArrival;
        this.stationDeparture = stationDeparture;
    }

    public ScheduleModel() {

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

    public Station getStationArrival() {
        return stationArrival;
    }

    public void setStationArrival(Station stationArrival) {
        this.stationArrival = stationArrival;
    }

    public Station getStationDeparture() {
        return stationDeparture;
    }

    public void setStationDeparture(Station stationDeparture) {
        this.stationDeparture = stationDeparture;
    }
}
