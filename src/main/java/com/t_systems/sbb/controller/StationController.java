package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.exception.NotFoundException;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/station")
public class StationController {
    @Autowired
    private GenericService<Station> stationGenericService;

    @GetMapping()
    public Collection<Station> listStations(){
        return stationGenericService.findAll();
    }

    @PostMapping()
    public void addStation(@RequestBody Station station){
        station.setIdStation(0);
        stationGenericService.save(station);
    }

    @PutMapping()
    public void saveStation(@RequestBody Station station){
        stationGenericService.save(station);
    }

    @PutMapping("/{id}")
    public void updateStation(@PathVariable("id") long id, @RequestBody Station station){
        stationGenericService.findById(id).setNameStation(station.getNameStation());
    }

    @DeleteMapping("/{id}")
    public void deleteStation(@PathVariable("id") long id){
        Station station = stationGenericService.findById(id);
        if (station == null) throw new NotFoundException("Station id not found - " + id);
        stationGenericService.deleteById(id);
    }
}
