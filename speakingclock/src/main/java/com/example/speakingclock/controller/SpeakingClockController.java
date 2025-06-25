package com.example.speakingclock.controller;

import com.example.speakingclock.service.SpeakingClockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @Autowired
    private SpeakingClockService  speakingClockService;

    @ApiOperation("Convert 24-hour time to words")
    @GetMapping("/convert")
    public String convertTimeToWords(@RequestParam String time) {
        return speakingClockService.convertTimeToWords(time);
    }
}