package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.models.ScheduleModel;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private GenericService<Station> stationGenericService;

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
    @PostMapping("/station/{id}")
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
    public String getScheduleByStation(@PathVariable int id, Model m){
        Station station = stationGenericService.findById(id);
        Collection<Schedule> schedules = scheduleService.getScheduleByStation(station.getIdStation());
        m.addAttribute("station", station);
        m.addAttribute("schedule",schedules);
        return "station_schedule";
    }

    @RequestMapping("/station/{id}/form")
    public String showStationForm(@PathVariable int id, Model m){
        ScheduleModel scheduleModel = new ScheduleModel(new Schedule());
        Station station = stationGenericService.findById(id);
        List<Train> trains = (List<Train>) trainGenericService.findAll();
        m.addAttribute("command", scheduleModel);
        m.addAttribute("station", station);
        m.addAttribute("trains", trains);
        return "station_schedule_add_form";
    }


    @GetMapping(value="/train/{id}")
    public String getScheduleByTrain(@PathVariable int id, Model m){
        Train train = trainGenericService.findById(id);
        Collection<Schedule> schedules = scheduleService.getScheduleByTrain(train.getNumberTrain());
        m.addAttribute("station", schedules);
        m.addAttribute("schedule",schedules);
        return "schedules";
    }
}
