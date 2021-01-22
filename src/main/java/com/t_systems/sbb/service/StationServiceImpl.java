package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.dto.StationDTO;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class StationServiceImpl {
    @Autowired
    private GenericDAO<Station> stationGenericDAO;

    @Autowired
    private StationMapper stationMapper;

    @Transactional
    public Station findById(long id) {
        return stationGenericDAO.findById(id);
    }

    @Transactional
    public StationDTO findByIdDTO(long id){
        return stationMapper.toDto(stationGenericDAO.findById(id));
    }

    @Transactional
    public Collection<Station> findAll() {
        return stationGenericDAO.findAll();
    }

    @Transactional
    public Collection<StationDTO> findAllDTO() {
        return stationMapper.toDto(stationGenericDAO.findAll());
    }

    @Transactional
    public void create(Station entity) {
        stationGenericDAO.create(entity);
    }

    @Transactional
    public void save(Station entity) {
        stationGenericDAO.save(entity);
    }

    @Transactional
    public void save(StationDTO stationDTO){
        Station entity = stationMapper.toEntity(stationDTO);
        stationGenericDAO.save(entity);
    }

    /*@Override*/
    @Transactional
    public void delete(Station entity) {
        stationGenericDAO.delete(entity);
    }

    /*@Override*/
    @Transactional
    public void deleteById(long entityId) {
        stationGenericDAO.deleteById(entityId);
    }
}
