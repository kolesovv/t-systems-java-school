package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "train")
public class Train implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long numberTrain;
    @Column(name = "train_name")
    private String trainName;
    @Column(name = "seats")
    private long seats;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "train_has_passenger",
            joinColumns =@JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private Set<Passenger> passengers;

    public Train() {
    }

    public Train(String trainName, long seats) {
        this.trainName = trainName;
        this.seats = seats;
    }

    public Train(String trainName) {
        this.trainName = trainName;
    }

    public long getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(long trainNumber) {
        this.numberTrain = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public long getSeats() {
        return seats;
    }

    public void setSeats(long seats) {
        this.seats = seats;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Train{" +
                "numberTrain=" + numberTrain +
                ", trainName='" + trainName + '\'' +
                ", seats=" + seats +
                ", passengers=" + passengers +
                '}';
    }
}
