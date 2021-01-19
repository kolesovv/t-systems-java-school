package com.t_systems.sbb.models;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.utils.DateUtil;

import java.util.Date;

public class ScheduleModel {
    private long id;
    private long trainId;
    private long stationId;
    private Date departureTime;
    private Date arrivalTime;
    private String trainNumber;
    private String nameStation;

    public ScheduleModel(){}

    public ScheduleModel(Schedule schedule){
        this.arrivalTime = getArrivalTime();
        this.departureTime = getDepartureTime();
        setId(schedule.getId());
        if(schedule.getTrain() != null){
            setTrainNumber(schedule.getTrain().getTrainName());
            setTrainId(schedule.getTrain().getNumberTrain());
        }
        if(schedule.getStation() != null){
            setStationId(schedule.getStation().getIdStation());
            setNameStation(schedule.getStation().getNameStation());
        }
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = DateUtil.convertScheduleTimeToDate(departureTime);
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = DateUtil.convertScheduleTimeToDate(arrivalTime);
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTrainId() {
        return trainId;
    }

    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }

}
