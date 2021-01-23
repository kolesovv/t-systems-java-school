package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.model.StationSchedule;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.ScheduleService;
import com.t_systems.sbb.service.StationScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationScheduleService stationScheduleService;

    @Autowired
    private GenericService<Station> stationService;

    @Autowired
    private GenericService<Train> trainGenericService;

    @GetMapping()
    public String getSchedule(Model m) {
        Collection<Schedule> schedules = scheduleService.findAll();
        m.addAttribute("schedule", schedules);
        return "schedules";
    }

//    @GetMapping(value="/{id}")
//    public String getSchedule(@PathVariable int id, Model m){
//        Schedule schedule = scheduleService.findById(id);
//        m.addAttribute("command",schedule);
//        return "schedule_edit_form";
//    }
//
//    @RequestMapping("/form")
//    public String showform(Model m){
//        m.addAttribute("command", new Schedule());
//        return "schedule_add_form";
//    }
//
//    @PostMapping("/new")
//    public String addSchedule(@ModelAttribute("schedule") Schedule schedule){
//        scheduleService.create(schedule);
//        return "redirect:/schedule";
//    }
//
    @PostMapping("/station")
    public String updateStation(@ModelAttribute("schedule") Schedule schedule){
        scheduleService.save(schedule);
        return "redirect:/schedule";
    }
//
//    @GetMapping(value="/delete/{id}")
//    public String delete(@PathVariable int id){
//        scheduleService.deleteById(id);
//        return "redirect:/schedule";
//    }

    @GetMapping(value="/station/{id}")
    public String getStationSchedule(@PathVariable int id, Model m){
        StationSchedule stationSchedule = stationScheduleService.getStationSchedule(id);
        m.addAttribute("stationSchedule",stationSchedule);
        return "station_schedule";
    }

    @RequestMapping("station/{id}/form")
    public String showStationForm(Model m, @PathVariable long id){
        Schedule schedule = new Schedule();
        Station station = stationService.findById(id);
        schedule.setStation(station);
        m.addAttribute("trains", trainGenericService.findAll());
        m.addAttribute("station", station);
        m.addAttribute("command", schedule);
        return "station_schedule_add_form";
    }


    @GetMapping(value="/train/{id}")
    public String getScheduleByTrain(@PathVariable int id, @ModelAttribute("train") Train train, Model m){
        Train currentTrain = trainGenericService.findById(id);
        Collection<Schedule> schedules = scheduleService.getScheduleByTrain(currentTrain.getNumberTrain());
        m.addAttribute("schedule",schedules);
        return "schedules";
    }
}
