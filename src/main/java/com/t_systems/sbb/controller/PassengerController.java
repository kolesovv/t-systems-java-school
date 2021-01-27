package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Passenger;
import com.t_systems.sbb.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private GenericService<Passenger> passengerGenericService;

    @GetMapping()
    public String getPassenger(Model m) {
        Collection<Passenger> passengers = passengerGenericService.findAll();
        m.addAttribute("passengers", passengers);
        return "passengers";
    }

    @GetMapping(value="/{id}")
    public String getPassenger(@PathVariable int id, Model m){
        Passenger passenger= passengerGenericService.findById(id);
        m.addAttribute("command",passenger);
        return "passenger_edit_form";
    }

    @RequestMapping("/form")
    public String showform(Model m){
        m.addAttribute("command", new Passenger());
        return "passenger_add_form";
    }

    /*@PostMapping("/new")
    public String addStation(@ModelAttribute("passenger") Passenger passenger){
        passengerGenericService.create(passenger);
        return "redirect:/passenger";
    }*/

    @PostMapping()
    public String updateStation(@ModelAttribute("passenger") Passenger passenger){
        passengerGenericService.save(passenger);
        return "redirect:/passenger";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable int id){
        passengerGenericService.deleteById(id);
        return "redirect:/passenger";
    }
}
