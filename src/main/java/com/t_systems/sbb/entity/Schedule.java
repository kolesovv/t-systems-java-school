package com.t_systems.sbb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "arrival_time")
    private Date arrivalTime;
    @Column(name = "departure_time")
    private Date departureTime;

    @ManyToOne
    @JoinColumn(name = "path_id")
    private Path path;

    @ManyToOne
    @JoinColumn(name = "train_number")
    private Train train;

    public Schedule() {
    }

    public Schedule(Date arrivalTime, Date departureTime, Path path, Train train) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.path = path;
        this.train = train;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @JsonBackReference
    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @JsonBackReference
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", path=" + path +
                ", train=" + train +
                '}';
    }
}
