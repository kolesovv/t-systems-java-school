package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "train_capacity")
public class TrainCapacity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "railway_carriage_number")
    private int railwayCarriageNumber;
    @Column(name = "seat_number")
    private int seatNumber;

    public TrainCapacity() {
    }

    public TrainCapacity(int railwayCarriageNumber, int seatNumber) {
        this.railwayCarriageNumber = railwayCarriageNumber;
        this.seatNumber = seatNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRailwayCarriageNumber() {
        return railwayCarriageNumber;
    }

    public void setRailwayCarriageNumber(int railwayCarriageNumber) {
        this.railwayCarriageNumber = railwayCarriageNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "TrainCapacity{" +
                "id=" + id +
                ", railwayCarriageNumber=" + railwayCarriageNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
