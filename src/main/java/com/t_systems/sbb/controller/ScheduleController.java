package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.TrainSearchService;
import com.t_systems.sbb.service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    TrainSearchService trainSearchService;

    @Autowired
    GenericService<Schedule> scheduleGenericService;

    @GetMapping()
    public Collection<Schedule> listSchedule(){
        return scheduleGenericService.findAll();
    }

    @PostMapping()
    public void addSchedule(@RequestBody Schedule schedule) {
        schedule.setId(0);
        scheduleGenericService.save(schedule);
    }

    @PutMapping()
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

    @GetMapping("/search-train")
    public @ResponseBody ModelMap getTrainsByPathAndTime(ModelMap model, HttpServletRequest request) {
        model.addAttribute("trains",
                trainSearchService.getTrainsByPathAndTime(
                        Long.parseLong(request.getParameter("stationIdDeparture")),
                        Date.valueOf(request.getParameter("departure")),
                        Long.parseLong(request.getParameter("stationIdArrival")),
                        Date.valueOf(request.getParameter("arrival"))));
        return model;
    }
}
