package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.PathService;
import com.t_systems.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    PathService pathService;

    @Autowired
    TrainService trainService;

    @Autowired
    GenericService<Schedule> scheduleGenericService;

    @GetMapping("/schedule")
    public String listSchedule(Model model){
        List<Schedule> scheduleList = scheduleGenericService.findAll();
        model.addAttribute("schedule", scheduleList);
        return "schedule";
    }

    @GetMapping("/addSchedule")
    public String addSchedule(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("path", pathService.getPaths());
        model.addAttribute("train", trainService.getTrain());
        return "schedule-form";
    }

    @PostMapping("/saveSchedule")
    public String saveSchedule(@ModelAttribute("schedule") Schedule schedule){
        scheduleGenericService.save(schedule);
        return "redirect:/schedule";
    }
}
