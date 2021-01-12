package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.GenericDAO;
import com.t_systems.sbb.entity.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class PathServiceImpl implements GenericService<Path> {

    @Autowired
    private GenericDAO<Path> pathGenericDAO;

    @Override
    @Transactional
    public Path findById(long id) {
        return pathGenericDAO.findById(id);
    }

    @Override
    @Transactional
    public Collection<Path> findAll() {
        return pathGenericDAO.findAll();
    }

    @Override
    @Transactional
    public void create(Path entity) {
        pathGenericDAO.create(entity);
    }

    @Override
    @Transactional
    public void save(Path entity) {
        pathGenericDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(Path entity) {
        pathGenericDAO.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(long entityId) {
        pathGenericDAO.deleteById(entityId);
    }
}
