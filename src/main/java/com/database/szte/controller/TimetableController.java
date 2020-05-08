package com.database.szte.controller;

import com.database.szte.data.Timetable;
import com.database.szte.dto.TimetableDTO;
import com.database.szte.service.ITimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class TimetableController extends BaseController {

    @Autowired
    private ITimetableService timetableService;

    @GetMapping("/timetables")
    public List<Timetable> getTimetables() {
        return timetableService.getAllTimetables();
    }

    @PostMapping("/timetable")
    public Timetable insertNewTimetable(@RequestBody final TimetableDTO dto) {
        return timetableService.saveNewTimetable(new Timetable(dto));
    }

    @GetMapping("/timetables/search")
    public List<Timetable> getTimetableByParams(@RequestParam final String to, @RequestParam final String from,
                                                @RequestParam final Instant when,
                                                @RequestParam(required = false) final List<String> stops) {
        return timetableService.getTimetableByParams(from, to, when, stops);
    }
}
