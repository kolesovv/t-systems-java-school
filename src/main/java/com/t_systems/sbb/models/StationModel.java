package com.t_systems.sbb.models;

import com.t_systems.sbb.entity.Station;

import java.util.List;

public class StationModel {
    private String stationName;
    private long id;
    private List<ScheduleModel> schedules;

    public StationModel(){}

    public StationModel(Station station){
        stationName = station.getNameStation();
        id = station.getIdStation();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ScheduleModel> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleModel> schedules) {
        this.schedules = schedules;
    }
}
