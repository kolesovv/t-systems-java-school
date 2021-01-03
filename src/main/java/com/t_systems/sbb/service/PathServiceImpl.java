package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.PathDAO;
import com.t_systems.sbb.entity.Path;
import com.t_systems.sbb.entity.Station;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private PathDAO pathDAO;

    @Override
    @Transactional
    public List<Path> getPaths() {
        return pathDAO.getPaths();
    }

    @Override
    @Transactional
    public void savePath(Path path) {
        pathDAO.savePath(path);
    }

    @Override
    @Transactional
    public Path getPath(int id) {
        return pathDAO.getPath(id);
    }

    @Override
    @Transactional
    public void deletePath(int id) {
        pathDAO.deletePath(id);
    }
}
