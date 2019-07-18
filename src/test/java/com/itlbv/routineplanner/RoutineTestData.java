package com.itlbv.routineplanner;

import com.itlbv.routineplanner.model.Routine;

import java.util.ArrayList;
import java.util.List;

public class RoutineTestData {
    private static final int GLOBAL_START_SEQ = 100000;
    public static final List<Routine> ROUTINES = new ArrayList<Routine>(populateList());

    private static List<Routine> populateList() {
        List<Routine> routines = new ArrayList<>();
        routines.add(new Routine(GLOBAL_START_SEQ, "name1"));
        routines.add(new Routine(GLOBAL_START_SEQ + 1, "name2"));
        routines.add(new Routine(GLOBAL_START_SEQ + 2, "name3"));
        return routines;
    }
}
