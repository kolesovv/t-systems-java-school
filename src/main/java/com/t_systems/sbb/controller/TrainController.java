package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping("/list-trains")
    public String listTrains(Model model){
        List<Train>trainList = trainService.getTrain();
        model.addAttribute("trains", trainList);
        return "list-trains";
    }

    @GetMapping("/addTrain")
    public String addTrain(Model model) {
        Train train = new Train();
        model.addAttribute("train", train);
        return "train-form";
    }

    @PostMapping("/saveTrain")
    public String saveTrain(@ModelAttribute("train") Train train){
        trainService.saveTrain(train);
        return "redirect:/list-trains";
    }

    @GetMapping("/updateTrain")
    public String updateTrain(@RequestParam("numberTrain")int id, Model model){
        Train train = trainService.getTrain(id);
        model.addAttribute("train", train);
        return "train-form";
    }

    @GetMapping("/deleteTrain")
    public String deleteTrain(@RequestParam("numberTrain") int id){
        trainService.deleteTrain(id);
        return "redirect:/list-trains";
    }
}
