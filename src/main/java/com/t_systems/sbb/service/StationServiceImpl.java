package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class StationServiceImpl {
    @Autowired
    private GenericDAO<Station> stationGenericDAO;

    @Transactional
    public Station findById(long id) {
        return stationGenericDAO.findById(id);
    }

    @Transactional
    public Collection<Station> findAll() {
        return stationGenericDAO.findAll();
    }

    @Transactional
    public void save(Station entity) {
        stationGenericDAO.save(entity);
    }

    @Transactional
    public void deleteById(long entityId) {
        stationGenericDAO.deleteById(entityId);
    }
}
