package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private GenericService<Train> trainService;
    @Autowired
    private GenericService<Station> stationService;
    @Autowired
    private GenericService<Schedule> scheduleService;

    @GetMapping()
    public String allSchedule(Model model){
        List<Schedule> scheduleList = (List<Schedule>) scheduleService.findAll();
        List<Station> stationList = (List<Station>) stationService.findAll();
        model.addAttribute("schedule", scheduleList)
                .addAttribute("station", stationList);
        return "admin";
    }

    @GetMapping("/addtrain")
    public String addTrain(Model model){
        Train train = new Train();
        model.addAttribute("train", train);
        return "train-form";
    }

    @PostMapping("/savetrain")
    public String saveTrain(@ModelAttribute("train") Train train){
        trainService.save(train);
        return "train-form";
    }

    @GetMapping("/addstation")
    public String addStation(Model model){
        Station station = new Station();
        model.addAttribute("station", station);
        return "station-form";
    }

    @PostMapping("/savestation")
    public String saveStation(@ModelAttribute("station") Station station){
        stationService.save(station);
        return "station-form";
    }
}
