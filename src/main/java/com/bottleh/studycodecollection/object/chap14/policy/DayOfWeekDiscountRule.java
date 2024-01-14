package com.bottleh.studycodecollection.object.chap14.policy;

import com.bottleh.studycodecollection.object.chap14.domain.DateTimeInterval;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DayOfWeekDiscountRule {

    private final List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private final Duration duration = Duration.ZERO;
    private final Money amount = Money.ZERO;

    public Money calculate(DateTimeInterval interval) {
        if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
            return amount.times((double) interval.duration().getSeconds() / duration.getSeconds());
        }

        return Money.ZERO;
    }
}
