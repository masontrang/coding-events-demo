package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {

        HashMap<String, String> events = new HashMap<>();
        events.put("Pi Pizza Eating Contest", "Winner wins lifetime supply of ranch!");
        events.put("Silicon Styles", "A fashion event for WFH programmers");
        events.put("Implementation Instrumentation", "can you code using a piano? lets find out...");
        model.addAttribute("events", events);
        return "events/index";
//
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
//        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
    }

}
