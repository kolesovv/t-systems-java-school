package com.t_systems.sbb.dao;

import com.t_systems.sbb.entity.Train;

import java.util.List;

public interface TrainDAO {
    List<Train> getTrain();

    void saveTrain(Train train);

    Train getTrain(int id);

    void deleteTrain(int id);
}
