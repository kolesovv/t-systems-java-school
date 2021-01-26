package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Passenger;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;

import java.util.Date;

public class TicketItem {
    private long id;
    private Passenger passenger;
    private Train train;
    private Station stationDeparture;
    private Date departure;
    private Station stationArrival;
    private Date arrival;

    public TicketItem(Passenger passenger, Train train, Station stationDeparture, Date departure, Station stationArrival, Date arrival) {
        this.passenger = passenger;
        this.train = train;
        this.stationDeparture = stationDeparture;
        this.departure = departure;
        this.stationArrival = stationArrival;
        this.arrival = arrival;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStationDeparture() {
        return stationDeparture;
    }

    public void setStationDeparture(Station stationDeparture) {
        this.stationDeparture = stationDeparture;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Station getStationArrival() {
        return stationArrival;
    }

    public void setStationArrival(Station stationArrival) {
        this.stationArrival = stationArrival;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
}
