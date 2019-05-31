package com.itlbv.routineplanner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

    @RequestMapping("/")
    public ModelAndView hello() {
        return new ModelAndView("index");
    }

    @RequestMapping("/routines")
    public ModelAndView routines() {
        return new ModelAndView("routines");
    }
}
