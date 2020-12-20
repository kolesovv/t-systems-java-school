package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @RequestMapping("/list-stations")
    public String listStations(Model model){
        List<Station> stationList = stationService.getStations();
        model.addAttribute("stations", stationList);
        return "list-stations";
    }
}
