package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("/list-stations")
    public String listStations(Model model){
        List<Station> stationList = stationService.getStations();
        model.addAttribute("stations", stationList);
        return "list-stations";
    }

    @GetMapping("/addStation")
    public String addStation(Model model){
        Station station = new Station();
        model.addAttribute("station", station);
        return "station-form";
    }

    @PostMapping("/saveStation")
    public String saveStation(@ModelAttribute("station") Station station){
        stationService.saveStation(station);
        return "redirect:/stations/list-stations";
    }

    @GetMapping("/updateStation")
    public String updateStation(@RequestParam("stationId") int id, Model model){
        Station station = stationService.getStation(id);
        model.addAttribute("station", station);
        return "station-form";
    }

    @GetMapping("/deleteStation")
    public String deleteStation(@RequestParam("stationId") int id){
        stationService.deleteStation(id);
        return "redirect:/stations/list-stations";
    }
}
