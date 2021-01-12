package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Path;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.exception.NotFoundException;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/path")
public class PathController {
    @Autowired
    private GenericService<Path> pathGenericService;

    @GetMapping("/")
    public Collection<Path> listPaths(){
        return pathGenericService.findAll();
    }

    @PostMapping()
    public void addPath(@RequestBody Path path) {
        path.setId(0);
        pathGenericService.save(path);
    }

    @PutMapping()
    public void savePath(@RequestBody Path path){
        pathGenericService.save(path);
    }

    @PutMapping("/{id}")
    public void updatePath(@PathVariable("id")long id, @RequestBody Path path){
        pathGenericService.findById(id).setStationFrom(path.getStationFrom());
        pathGenericService.findById(id).setStationTo(path.getStationTo());
    }

    @DeleteMapping("/{id}")
    public void deletePath(@PathVariable("id") long id){
        Path path = pathGenericService.findById(id);
        if (path == null) throw new NotFoundException("Path id not found - " + id);
        pathGenericService.deleteById(id);
    }
}
