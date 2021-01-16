package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.TrainSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterFactoryBean;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

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

    @GetMapping("/search-trains")
    public ModelMap getTrainsByPathAndTime(@RequestParam("from") Long stationIdDeparture,
                                           @RequestParam("dep") String departureString,
                                           @RequestParam("to") Long stationIdArrival,
                                           @RequestParam("arr") String arrivalString,
                                           ModelMap model) {
        try {
            String pattern = "yyyy-MM-dd";
            java.util.Date departureDate = new SimpleDateFormat(pattern).parse(departureString);
            java.util.Date arrivalDate = new SimpleDateFormat(pattern).parse(arrivalString);
            Date departure = new Date(departureDate.getTime());
            Date arrival = new Date(arrivalDate.getTime());
            model.addAttribute("trains",
                    trainSearchService.getTrainsByPathAndTime
                            (stationIdDeparture, departure, stationIdArrival, arrival));
            return model;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
