package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_number")
    private int numberTrain;
    @Column(name = "train_name")
    private String trainName;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "train_path",
            joinColumns = @JoinColumn(name = "train_number"),
            inverseJoinColumns = @JoinColumn(name = "path_id"))
    private List<Path> pathList;

    public Train() {
    }

    public Train(String trainName) {
        this.trainName = trainName;
    }

    public int getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(int trainNumber) {
        this.numberTrain = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<Path> getPathList() {
        return pathList;
    }

    public void setPathList(List<Path> pathList) {
        this.pathList = pathList;
    }

    public void addPath(Path path){
        if (pathList == null) pathList = new ArrayList<>();
        pathList.add(path);
    }

    @Override
    public String toString() {
        return "Train{" +
                "numberTrain=" + numberTrain +
                ", trainName='" + trainName + '\'' +
                ", pathList=" + pathList +
                '}';
    }
}
