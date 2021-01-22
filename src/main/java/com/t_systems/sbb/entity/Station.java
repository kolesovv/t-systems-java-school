package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "station")
public class Station implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "station_name")
    private String nameStation;
    @OneToMany(mappedBy = "station",fetch=FetchType.LAZY)
    private List<Schedule> stationSchedule;

    public Station() {
    }

    public Station(long id, String name) {
        this.id = id;
        this.nameStation = name;
    }

    public long getIdStation() {
        return id;
    }

    public void setIdStation(long idStation) {
        this.id = idStation;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public List<Schedule> getStationSchedule() {
        return stationSchedule;
    }

    public void setStationSchedule(List<Schedule> stationSchedule) {
        this.stationSchedule = stationSchedule;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + nameStation + '\'' +
                '}';
    }
}
