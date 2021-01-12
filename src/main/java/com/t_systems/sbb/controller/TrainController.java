package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.exception.NotFoundException;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private GenericService<Train> trainGenericService;

    @GetMapping("/")
    public Collection<Train> listTrains(){
        return trainGenericService.findAll();
    }

    @PostMapping()
    public void addTrain(@RequestBody Train train) {
        train.setNumberTrain(0);
        trainGenericService.save(train);
    }

    @PutMapping()
    public void saveTrain(@RequestBody Train train){
        trainGenericService.save(train);
    }

    @PutMapping("/{id}")
    public void updateTrain(@PathVariable("id")long id, @RequestBody Train train){
        trainGenericService.findById(id).setTrainName(train.getTrainName());
    }

    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable("id") long id){
        Train train = trainGenericService.findById(id);
        if (train == null) throw new NotFoundException("Train id not found - " + id);
        trainGenericService.deleteById(id);
    }
}
