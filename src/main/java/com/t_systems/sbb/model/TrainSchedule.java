package com.t_systems.sbb.model;

import com.t_systems.sbb.entity.Train;

import java.util.List;

public class TrainSchedule {
    private Train train;
    private List<TrainScheduleItem> scheduleItemList;

    public TrainSchedule(Train train, List<TrainScheduleItem> scheduleItemList) {
        this.train = train;
        this.scheduleItemList = scheduleItemList;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<TrainScheduleItem> getScheduleItemList() {
        return scheduleItemList;
    }

    public void setScheduleItemList(List<TrainScheduleItem> scheduleItemList) {
        this.scheduleItemList = scheduleItemList;
    }
}
