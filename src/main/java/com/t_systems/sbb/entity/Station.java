package com.t_systems.sbb.entity;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private int idStation;
    @Column(name = "station_name")
    private String nameStation;

    public Station() {
    }

    public Station(int id, String name) {
        this.idStation = id;
        this.nameStation = name;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + idStation +
                ", name='" + nameStation + '\'' +
                '}';
    }
}
