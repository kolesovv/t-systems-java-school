package com.t_systems.sbb.dto;

import java.util.LinkedList;

public class StationDTO {
    private long id;
    private String nameStation;
    private LinkedList<ScheduleStationDTO> scheduleStationDTOS;

    public StationDTO() {
    }

    public StationDTO(long id, String nameStation) {
        this.id = id;
        this.nameStation = nameStation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public LinkedList<ScheduleStationDTO> getScheduleStationDTOS() {
        return scheduleStationDTOS;
    }

    public void setScheduleStationDTOS(LinkedList<ScheduleStationDTO> scheduleStationDTOS) {
        this.scheduleStationDTOS = scheduleStationDTOS;
    }
}
