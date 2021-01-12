package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "station")
public class Station implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idStation;
    @Column(name = "station_name")
    private String nameStation;

    public Station() {
    }

    public Station(long id, String name) {
        this.idStation = id;
        this.nameStation = name;
    }

    public long getIdStation() {
        return idStation;
    }

    public void setIdStation(long idStation) {
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
