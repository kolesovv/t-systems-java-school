package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.TrainDAOImpl;
import com.t_systems.sbb.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDAOImpl trainDAO;

    @Override
    @Transactional
    public List<Train> getTrain() {
        return trainDAO.getTrain();
    }

    @Override
    @Transactional
    public void saveTrain(Train train) {
        trainDAO.saveTrain(train);
    }

    @Override
    @Transactional
    public Train getTrain(int id) {
        return trainDAO.getTrain(id);
    }

    @Override
    @Transactional
    public void deleteTrain(int id) {
        trainDAO.deleteTrain(id);
    }
}
