package com.bottleh.studycodecollection.object.chap14.domain;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {

    @Getter
    private final DateTimeInterval interval;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.interval = DateTimeInterval.of(from, to);
    }

    public Duration getDuration() {
        return interval.duration();
    }

    public LocalDateTime getFrom() {
        return interval.getFrom();
    }

    public LocalDateTime getTo() {
        return interval.getTo();
    }

    public List<DateTimeInterval> splitByDay() {
        return interval.splitByDay();
    }
}
