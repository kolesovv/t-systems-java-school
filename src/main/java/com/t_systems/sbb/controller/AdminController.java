package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping({"/admin", "/admin/"})
public class AdminController {

    @Autowired
    GenericService<Train> trainService;

    @Autowired
    GenericService<Station> stationService;

    @PostMapping("/addtrain")
    public String addTrain(Model model){
        Train train = new Train();
        model.addAttribute("train", train);
        return "administration-form";
    }

    @GetMapping()
    public Collection<Train> listTrains(){
        return trainService.findAll();
    }

    @PostMapping("/addstation")
    public String addStation(Model model){
        Station station = new Station();
        model.addAttribute("station", station);
        return "administration-form";
    }
}
