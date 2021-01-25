package com.t_systems.sbb.controller;

import com.t_systems.sbb.entity.Schedule;
import com.t_systems.sbb.entity.Station;
import com.t_systems.sbb.entity.Train;
import com.t_systems.sbb.model.ScheduleItem;
import com.t_systems.sbb.model.StationSchedule;
import com.t_systems.sbb.service.GenericService;
import com.t_systems.sbb.service.ScheduleService;
import com.t_systems.sbb.service.StationScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/schedule/station")
@SessionAttributes({"stationSchedule", "trains"})
public class StationScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationScheduleService stationScheduleService;

    @Autowired
    private GenericService<Train> trainGenericService;

    @GetMapping(value = "/{id}")
    public String getStationSchedule(@PathVariable int id, Model m) {
        StationSchedule stationSchedule = stationScheduleService.getStationSchedule(id);
        m.addAttribute("stationSchedule", stationSchedule);
        return "station_schedule";
    }

    @RequestMapping("/{id}/form")
    public String showStationScheduleForm(@PathVariable long id, Model m) {
        Collection<Train> trains = trainGenericService.findAll();
        ScheduleItem scheduleItem = new ScheduleItem();
        scheduleItem.setId(0);
        m.addAttribute("trains", trains);
        m.addAttribute("command", scheduleItem);
        return "station_schedule_add_form";
    }

    @GetMapping(value="/{id}/edit")
    public String getStationScheduleForm(@PathVariable int id, Model m){
        Collection<Train> trains = trainGenericService.findAll();
        Schedule schedule = scheduleService.findById(id);
        m.addAttribute("schedule", schedule);
        m.addAttribute("trains", trains);
        m.addAttribute("command", new ScheduleItem(id, schedule.getTrain().getNumberTrain(),
                null, null));
        return "station_schedule_edit_form";
    }

    @PostMapping("/add")
    public String addStationSchedule(@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
                                        @ModelAttribute("stationSchedule") StationSchedule stationSchedule,
                                        @ModelAttribute("trains") Collection<Train> trains,
                                        SessionStatus status) {
        Map<Long, Train> trainMap = new HashMap<>();
        for (Train train : trains) {
            trainMap.put(train.getNumberTrain(), train);
        }
        Train train = trainMap.get(scheduleItem.getItemId());
        Station station = stationSchedule.getStation();
        Schedule schedule = new Schedule(scheduleItem.getDepartureTime(),
                                         scheduleItem.getArrivalTime(),
                                         station, train);
        scheduleService.save(schedule);
        status.setComplete();
        return "redirect:/schedule/station/" + station.getIdStation();
    }

    @PostMapping("/update")
    public String updateStationSchedule(@ModelAttribute("scheduleItem") ScheduleItem scheduleItem,
                                        @ModelAttribute("stationSchedule") StationSchedule stationSchedule,
                                        @ModelAttribute("trains") Collection<Train> trains,
                                        SessionStatus status) {
        Map<Long, Train> trainMap = new HashMap<>();
        for (Train train : trains) {
            trainMap.put(train.getNumberTrain(), train);
        }
        Train train = trainMap.get(scheduleItem.getItemId());
        Station station = stationSchedule.getStation();
        Schedule schedule = scheduleService.findById(scheduleItem.getId());
            schedule.setDepartureTime(scheduleItem.getDepartureTime());
            schedule.setArrivalTime(scheduleItem.getArrivalTime());
            schedule.setTrain(train);
            schedule.setStation(station);
        scheduleService.save(schedule);
        status.setComplete();
        return "redirect:/schedule/station/" + station.getIdStation();
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id,
                         @ModelAttribute("stationSchedule") StationSchedule stationSchedule,
                         SessionStatus status) {
        scheduleService.deleteById(id);
        status.setComplete();
        return "redirect:/schedule/station/" + stationSchedule.getStation().getIdStation();
    }
}
