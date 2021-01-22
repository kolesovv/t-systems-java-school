package com.t_systems.sbb.controller;

import com.t_systems.sbb.dto.TrainDTO;
import com.t_systems.sbb.service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainServiceImpl trainGenericService;

    @GetMapping()
    public ModelAndView getTrains() {
        List<TrainDTO> trainDTOList = (List<TrainDTO>) trainGenericService.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trains");
        modelAndView.addObject("trainList", trainDTOList);
        return modelAndView;
    }

    @GetMapping (value = "/edit/{id}")
    public ModelAndView getTrain(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        TrainDTO trainDTO = trainGenericService.findByIdDTO(id);
        modelAndView.setViewName("train_edit_form");
        modelAndView.addObject("trainDTO", trainDTO);
        return modelAndView;
    }

    @GetMapping(value = "/form")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        TrainDTO train = new TrainDTO();
        train.setId(0);
        modelAndView.setViewName("train_edit_form");
        modelAndView.addObject("command", train);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView updateTrain(@ModelAttribute("trainDTO") TrainDTO trainDTO) {
        trainGenericService.save(trainDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/train");
        return modelAndView;
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        trainGenericService.deleteByIdDTO(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/train");
        return modelAndView;
    }
}
