package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Station;

import java.util.List;

public class StationSchedule {
    private Station station;
    private List<StationScheduleItem> scheduleItemList;

    public StationSchedule(Station station, List<StationScheduleItem> scheduleItemList) {
        this.station = station;
        this.scheduleItemList = scheduleItemList;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<StationScheduleItem> getScheduleItemList() {
        return scheduleItemList;
    }

    public void setScheduleItemList(List<StationScheduleItem> scheduleItemList) {
        this.scheduleItemList = scheduleItemList;
    }
}
