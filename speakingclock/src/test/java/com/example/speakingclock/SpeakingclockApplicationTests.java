package com.example.speakingclock;

import com.example.speakingclock.exception.InvalidTimeException;
import com.example.speakingclock.service.SpeakingClockService;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpeakingclockApplicationTests {

	private SpeakingClockService service = new SpeakingClockService();

	@Test
    public void test_Midnight() {
        assertEquals("It's Midnight", service.convertTimeToWords("00:00"));
    }

    @Test
    public void test_Midday() {
        assertEquals("It's Midday", service.convertTimeToWords("12:00"));
    }

    @Test
    public void test_MorningTime() {
        assertEquals("It's eight thirty four", service.convertTimeToWords("08:34"));
    }

    @Test
    public void test_RegularTime() {
        assertEquals("It's eleven o'clock", service.convertTimeToWords("11:00"));
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidFormat() {
        service.convertTimeToWords("25:00");
    }
}
