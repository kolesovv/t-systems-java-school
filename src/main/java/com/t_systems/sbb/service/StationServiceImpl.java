package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class StationServiceImpl /*implements GenericService<Station>*/ {
    @Autowired
    private GenericDAO<Station> stationGenericDAO;

    //@Override
    @Transactional
    public Station findById(long id) {
        return stationGenericDAO.findById(id);
    }

    //@Override
    @Transactional
    public Collection<Station> findAll() {
        return stationGenericDAO.findAll();
    }

    //@Override
    @Transactional
    public void create(Station entity) {
        stationGenericDAO.create(entity);
    }

    //@Override
    @Transactional
    public void save(Station entity) {
        stationGenericDAO.save(entity);
    }

    //@Override
    @Transactional
    public void delete(Station entity) {
        stationGenericDAO.delete(entity);
    }

    //@Override
    @Transactional
    public void deleteById(long entityId) {
        stationGenericDAO.deleteById(entityId);
    }
}
