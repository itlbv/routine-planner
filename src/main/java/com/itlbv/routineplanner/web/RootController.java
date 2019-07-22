package com.itlbv.routineplanner.web;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RootController {

    private final RoutineService service;

    @Autowired
    public RootController(RoutineService routineService) {
        this.service = routineService;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/routines")
    public ModelAndView routines() {
        List<Routine> routines = service.getAll();
        ModelAndView model = new ModelAndView("routines");
        model.addObject("routines", routines);
        return model;
    }
}
