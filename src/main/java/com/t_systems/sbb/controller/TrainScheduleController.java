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
        ScheduleItem scheduleItem = new ScheduleItem();
        scheduleItem.setId(0);
        m.addAttribute("stations", stations);
        m.addAttribute("command", scheduleItem);
        return "train_schedule_add_form";
    }

    @GetMapping(value="/{id}/edit")
    public String getStationScheduleForm(@PathVariable int id, Model m){
        Collection<Station> stations = stationGenericService.findAll();
        Schedule schedule = scheduleService.findById(id);
        m.addAttribute("schedule", schedule);
        m.addAttribute("stations", stations);
        m.addAttribute("command", new ScheduleItem(id, schedule.getTrain().getNumberTrain(),
                null, null));
        return "train_schedule_edit_form";
    }

    @PostMapping("/add")
    public String addTrainSchedule(@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
                                      @ModelAttribute("stationSchedule") TrainSchedule trainSchedule,
                                      @ModelAttribute("stations") Collection<Station> stations,
                                      SessionStatus status) {
        Map<Long, Station> stationMap = new HashMap<>();
        for (Station station : stations) {
            stationMap.put(station.getIdStation(), station);
        }
        Train train = trainSchedule.getTrain();
        Station station = stationMap.get(scheduleItem.getItemId());
        Schedule schedule = new Schedule(scheduleItem.getDepartureTime(),
                                         scheduleItem.getArrivalTime(),
                                         station, train);
        scheduleService.save(schedule);
        status.setComplete();
        return "redirect:/schedule/train/" + train.getNumberTrain();
    }

    @PostMapping("/update")
    public String updateTrainSchedule(@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
                                        @ModelAttribute("stationSchedule") TrainSchedule trainSchedule,
                                        @ModelAttribute("stations") Collection<Station> stations,
                                        SessionStatus status) {
        Map<Long, Station> stationMap = new HashMap<>();
        for (Station station : stations) {
            stationMap.put(station.getIdStation(), station);
        }
        Train train = trainSchedule.getTrain();
        Station station = stationMap.get(scheduleItem.getItemId());
        Schedule schedule = scheduleService.findById(scheduleItem.getId());
            schedule.setDepartureTime(scheduleItem.getDepartureTime());
            schedule.setArrivalTime(scheduleItem.getArrivalTime());
            schedule.setTrain(train);
            schedule.setStation(station);
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
