package com.example.speakingclock.service;

import com.example.speakingclock.exception.InvalidTimeException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TimeService {

    private static final String[] numbers = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen"
    };
    
    private static final String[] tens = {
        "", "", "twenty", "thirty", "forty", "fifty"
    };

    public String convertTimeToWords(String time) {
        try {
            if (time.equals("00:00")) return "It's Midnight";
            if (time.equals("12:00")) return "It's Midday";

            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
            int hour = localTime.getHour();
            int minute = localTime.getMinute();

            String hourWord = convertNumberToWords(hour);
            String minuteWord = minute == 0 ? "o'clock" : convertNumberToWords(minute);
            return "It's " + hourWord + (minute == 0 ? " " : " ") + minuteWord;
        } catch (DateTimeParseException e) {
            throw new InvalidTimeException("Invalid time format. Use HH:mm (24-hour).");
        }
    }

    private String convertNumberToWords(int num) {
        if (num < 20) {
            return numbers[num];
        } else {
            return tens[num / 10] + (num % 10 == 0 ? "" : " " + numbers[num % 10]);
        }
    }
}