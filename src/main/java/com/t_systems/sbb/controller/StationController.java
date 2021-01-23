package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/station")
public class StationController {
    @Autowired
    private GenericService<Station> stationGenericService;

    @GetMapping()
    public String getStations(Model m) {
        Collection<Station> stations = stationGenericService.findAll();
        m.addAttribute("stations", stations);
        return "stations";
    }

    @GetMapping(value="/{id}")
    public String getStation(@PathVariable int id, Model m){
        Station station = stationGenericService.findById(id);
        m.addAttribute("command",station);
        return "station_edit_form";
    }

    @RequestMapping("/form")
    public String showForm(Model m){
        m.addAttribute("command", new Station());
        return "station_add_form";
    }

    @PostMapping("/new")
    public String addStation(@ModelAttribute("station")  Station station){
        stationGenericService.create(station);
        return "redirect:/station";
    }

    @PostMapping()
    public String updateStation(@ModelAttribute("station") Station station){
        stationGenericService.save(station);
        return "redirect:/station";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable int id){
        stationGenericService.deleteById(id);
        return "redirect:/station";
    }
}
