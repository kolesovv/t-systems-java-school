package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private GenericService<Train> trainGenericService;

    @GetMapping()
    public String getTrains(Model m) {
        Collection<Train> train = trainGenericService.findAll();
        m.addAttribute("trains", train);
        return "trains";
    }

    @GetMapping(value="/{id}")
    public String getTrain(@PathVariable int id, Model m){
        Train train = trainGenericService.findById(id);
        m.addAttribute("command",train);
        return "train_edit_form";
    }

    @RequestMapping("/form")
    public String showform(Model m){
        m.addAttribute("command", new Train());
        return "train_add_form";
    }

    @PostMapping("/new")
    public String addTrain(@ModelAttribute("train") Train train){
        trainGenericService.create(train);
        return "redirect:/train";
    }

    @PostMapping()
    public String updateTrain(@ModelAttribute("train") Train train){
        trainGenericService.save(train);
        return "redirect:/train";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable int id){
        trainGenericService.deleteById(id);
        return "redirect:/train";
    }
}
