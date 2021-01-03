package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.StationDAO;
import com.t_systems.sbb.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDAO stationDAO;

    @Override
    @Transactional
    public List<Station> getStations() {
        return stationDAO.getStations();
    }

    @Override
    @Transactional
    public void saveStation(Station station) {
        stationDAO.saveStation(station);
    }

    @Override
    @Transactional
    public Station getStation(int id) {
        return stationDAO.getStation(id);
    }

    @Override
    @Transactional
    public void deleteStation(int id) {
        stationDAO.deleteStation(id);
    }
}
