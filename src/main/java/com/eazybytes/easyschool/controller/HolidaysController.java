package com.eazybytes.easyschool.controller;

import com.eazybytes.easyschool.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @RequestMapping("/holidays")
    public String displayHolidays(Model model) {
        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Cristmas", Holiday.Type.FESTIVAL),
                new Holiday(" Sep 7 ", "Idempedency Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 15 ", "Repuplic Poclamation", Holiday.Type.FEDERAL),
                new Holiday(" Nov 20 ", "Zumbi dos Palmares", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();

        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).
                            collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
