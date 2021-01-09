package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "path")
public class Path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "station_from", referencedColumnName = "id", insertable = false, updatable = false)
    private Station stationFrom;
    @ManyToOne
    @JoinColumn(name = "station_to", referencedColumnName = "id", insertable = false, updatable = false)
    private Station stationTo;
    @OneToMany(mappedBy = "path", targetEntity = Schedule.class, fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Schedule> scheduleList;

    public Path() {
    }

    public Path(Station stationFrom, Station stationTo, List<Schedule> scheduleList) {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.scheduleList = scheduleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(Station stationFrom) {
        this.stationFrom = stationFrom;
    }

    public Station getStationTo() {
        return stationTo;
    }

    public void setStationTo(Station stationTo) {
        this.stationTo = stationTo;
    }

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
        schedule.setPath(this);
    }

    @Override
    public String toString() {
        return "Path{" +
                "id=" + id +
                ", stationFrom=" + stationFrom +
                ", stationTo=" + stationTo +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
