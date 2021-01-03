package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "path")
public class Path {
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "station_from")
    private Station stationFrom;
    @ManyToOne
    @JoinColumn(name = "station_to")
    private Station stationTo;
    @Column(name = "arrival_time")
    private Date arrivalTime;
    @Column(name = "departure_time")
    private Date departureTime;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "train_path",
            joinColumns = @JoinColumn(name = "path_id"),
            inverseJoinColumns = @JoinColumn(name = "train_number"))
    private List<Train> trainList;


    public Path() {
    }

    public Path(Station stationFrom, Station stationTo, Date arrivalTime, Date departureTime) {
        this.stationTo = stationFrom;
        this.stationTo = stationTo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(Station stationFrom) {
        this.stationFrom = stationFrom;
    }

    public Station getStationTo() {
        return stationTo;
    }

    public void setStationTo(Station stationTo) {
        this.stationTo = stationTo;
    }

    public Date getArrivalTime() throws ParseException {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() throws ParseException {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Path{" +
                "id=" + id +
                ", stationFrom='" + stationFrom + '\'' +
                ", stationTo='" + stationTo + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
