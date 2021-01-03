package com.t_systems.sbb.service;

import com.t_systems.sbb.entity.Train;

import java.util.List;

public interface TrainService {
    List<Train> getTrain();

    void saveTrain(Train train);

    Train getTrain(int id);

    void deleteTrain(int id);
}
