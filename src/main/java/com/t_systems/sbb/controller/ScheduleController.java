package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Path;
import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    GenericService<Path> pathGenericService;

    @Autowired
    GenericService<Train> trainGenericService;

    @Autowired
    GenericService<Schedule> scheduleGenericService;

    @GetMapping("/")
    public Collection<Schedule> listSchedule(){
        return scheduleGenericService.findAll();
    }

    @PostMapping()
    public void addSchedule(@RequestBody Schedule schedule) {
        schedule.setId(0);
        scheduleGenericService.save(schedule);
    }

    @PutMapping("/saveSchedule")
    public void saveSchedule(@RequestBody Schedule schedule){
        scheduleGenericService.save(schedule);
    }

    @PutMapping({"/{id}"})
    public void updateSchedule(@PathVariable("id") long id, @RequestBody Schedule schedule){

    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable("id") long id){
        scheduleGenericService.deleteById(id);
    }
}
