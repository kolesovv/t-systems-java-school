package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Station;

import java.util.List;

public interface StationDAO {
    List<Station> getStations();

    void saveStation (Station station);

    Station getStation(int id);

    void deleteStation(int id);
}
