package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "train_capacity_id")
    private List<TrainCapacity> trainCapacities;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "train_has_passenger",
            joinColumns =@JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private Set<Passenger> passengers;

    public Train() {
    }

    public Train(String trainName, List<TrainCapacity> trainCapacities, Set<Passenger> passengers) {
        this.trainName = trainName;
        this.trainCapacities = trainCapacities;
        this.passengers = passengers;
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

    public List<TrainCapacity> getTrainCapacities() {
        return trainCapacities;
    }

    public void setTrainCapacities(List<TrainCapacity> trainCapacities) {
        this.trainCapacities = trainCapacities;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    /*public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }*/

    @Override
    public String toString() {
        return "Train{" +
                "numberTrain=" + numberTrain +
                ", trainName='" + trainName + '\'' +
                ", trainCapacities=" + trainCapacities +
                ", passengers=" + passengers +
                '}';
    }
}
