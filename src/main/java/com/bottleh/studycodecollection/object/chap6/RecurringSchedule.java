package com.bottleh.studycodecollection.object.chap6;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@AllArgsConstructor
public class RecurringSchedule {

    private String subject;

    @Getter
    private DayOfWeek dayOfWeek;

    @Getter
    private LocalTime from;

    @Getter
    private Duration duration;
}
