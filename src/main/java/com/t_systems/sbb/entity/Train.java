package com.t_systems.sbb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train")
public class Train implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private long numberTrain;
    @Column(name = "train_name")
    private String trainName;
    @OneToMany(mappedBy = "train", targetEntity = Schedule.class, fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Schedule> scheduleList;

    public Train() {
    }

    public Train(String trainName, List<Schedule> scheduleList) {
        this.trainName = trainName;
        this.scheduleList = scheduleList;
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

    @JsonManagedReference
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public void addSchedule(Schedule schedule){
        if(scheduleList == null){
            scheduleList = new ArrayList<>();
        }

        scheduleList.add(schedule);
        schedule.setTrain(this);
    }

    @Override
    public String toString() {
        return "Train{" +
                "numberTrain=" + numberTrain +
                ", trainName='" + trainName + '\'' +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
