package com.itlbv.routineplanner.web;

import com.itlbv.routineplanner.model.Routine;
import com.itlbv.routineplanner.model.User;
import com.itlbv.routineplanner.service.RoutineService;
import com.itlbv.routineplanner.service.UserService;
import com.itlbv.routineplanner.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RootController {

    private final RoutineService routineService;
    private final UserService userService;

    @Autowired
    public RootController(RoutineService routineService, UserService userService) {
        this.routineService = routineService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/routines")
    public ModelAndView routines() {
        List<Routine> routines = routineService.getAll(SecurityUtil.USER_01_ID);
        ModelAndView model = new ModelAndView("routines");
        model.addObject("routines", routines);
        return model;
    }

    @RequestMapping("/users")
    public ModelAndView users() {
        List<User> users = userService.getAll();
        ModelAndView model = new ModelAndView("users");
        model.addObject("users", users);
        return model;
    }
}
