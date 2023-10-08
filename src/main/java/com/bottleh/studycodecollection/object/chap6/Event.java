package com.bottleh.studycodecollection.object.chap6;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
public class Event {

    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public boolean isSatisfied(RecurringSchedule schedule) {
        return from.getDayOfWeek() == schedule.getDayOfWeek() && from.toLocalTime().equals(schedule.getFrom()) && duration.equals(schedule.getDuration());
    }

    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
