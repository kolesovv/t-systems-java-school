package com.t_systems.sbb.controller;

import com.t_systems.sbb.dto.StationDTO;
import com.t_systems.sbb.service.StationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationServiceImpl stationGenericService;

    @GetMapping()
    public ModelAndView getStations() {
        List<StationDTO> stationDTOList = (List<StationDTO>) stationGenericService.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stations");
        modelAndView.addObject("stationList", stationDTOList);
        return modelAndView;
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView getStation(@PathVariable("id") long id) {
        StationDTO stationDTO = stationGenericService.findByIdDTO(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station_edit_form");
        modelAndView.addObject("command", stationDTO);
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView();
        StationDTO station = new StationDTO();
        station.setId(0);
        modelAndView.addObject("command", station);
        modelAndView.setViewName("station_edit_form");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView updateStation(@ModelAttribute("station") StationDTO stationDTO) {
        stationGenericService.save(stationDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/station");
        return modelAndView;
    }

    @GetMapping (value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        stationGenericService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/station");
        return modelAndView;
    }
}
