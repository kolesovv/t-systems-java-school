package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Path;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.PathService;
import com.t_systems.sbb.service.StationService;
import com.t_systems.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class PathController {
    @Autowired
    private PathService pathService;

    @GetMapping("/list-paths")
    public String listPaths(Model model){
        List<Path> pathList = pathService.getPaths();
        model.addAttribute("paths", pathList);
        return "schedule";
    }

    @GetMapping("/addPath")
    public String addPath(Model model) {
        Path path = new Path();
        model.addAttribute("path", path);
        return "schedule-form";
    }

    @PostMapping("/savePath")
    public String savePath(@ModelAttribute("path") Path path){
        pathService.savePath(path);
        return "schedule";
    }

    @GetMapping("/updatePath")
    public String updatePath(@RequestParam("id")int id, Model model){
        Path path = pathService.getPath(id);
        model.addAttribute("path", path);
        return "schedule-form";
    }

    @GetMapping("/deletePath")
    public String deletePath(@RequestParam("id") int id){
        pathService.deletePath(id);
        return "schedule";
    }
}
