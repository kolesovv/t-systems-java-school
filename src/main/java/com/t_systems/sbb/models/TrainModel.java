package com.t_systems.sbb.models;

import com.t_systems.sbb.entity.Train;

import java.util.List;

public class TrainModel {
    private String trainNumber;
    private long seats;
    private long id;
    private List<StationModel> stations;

    public TrainModel(){}

    public TrainModel(Train train){
        trainNumber = train.getTrainName();
        seats = train.getSeats();
        setId(train.getNumberTrain());
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public long getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<StationModel> getStations() {
        return stations;
    }

    public void setStations(List<StationModel> stations) {
        this.stations = stations;
    }
}
