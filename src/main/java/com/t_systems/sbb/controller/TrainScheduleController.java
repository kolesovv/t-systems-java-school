package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.model.ScheduleItem;
import com.t_systems.sbb.model.StationSchedule;
import com.t_systems.sbb.model.TrainSchedule;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.ScheduleService;
import com.t_systems.sbb.service.TrainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/schedule/train")
@SessionAttributes({"trainSchedule", "stations"})
public class TrainScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainScheduleService trainScheduleService;

    @Autowired
    private GenericService<Station> stationGenericService;

    @GetMapping(value = "/{id}")
    public String getTrainSchedule(@PathVariable int id, Model m) {
        TrainSchedule trainSchedule = trainScheduleService.getTrainSchedule(id);
        m.addAttribute("trainSchedule", trainSchedule);
        return "train_schedule";
    }

    @RequestMapping("/{id}/form")
    public String showTrainScheduleForm(@PathVariable long id, Model m) {
        Collection<Station> stations = stationGenericService.findAll();
        m.addAttribute("stations", stations);
        m.addAttribute("command", new ScheduleItem());
        return "train_schedule_add_form";
    }

    @PostMapping()
    public String updateTrainSchedule(@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
                                        @ModelAttribute("stationSchedule") TrainSchedule trainSchedule,
                                        @ModelAttribute("trains") Collection<Station> stations,
                                        SessionStatus status) {
        Map<Long, Station> stationMap = new HashMap<>();
        for (Station station : stations) {
            stationMap.put(station.getIdStation(), station);
        }
        Train train = trainSchedule.getTrain();
        Station station = stationMap.get(scheduleItem.getItemId());
        Schedule schedule = new Schedule(new Date(), new Date(), station, train);
        scheduleService.save(schedule);
        status.setComplete();
        return "redirect:/schedule/train/" + train.getNumberTrain();
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id,
                         @ModelAttribute("stationSchedule") StationSchedule stationSchedule,
                         SessionStatus status) {
        scheduleService.deleteById(id);
        status.setComplete();
        return "redirect:/schedule/train/" + stationSchedule.getStation().getIdStation();
    }


}
