package com.bottleh.studycodecollection.object.chap5;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@AllArgsConstructor
public class PeriodCondition implements DiscountCondition {

    /**
     * 요일
     */
    private DayOfWeek dayOfWeek;

    /**
     * 시작 시간
     */
    private LocalTime startTime;

    /**
     * 종료 시간
     */
    private LocalTime endTime;

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                !startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
                !endTime.isBefore(screening.getWhenScreened().toLocalTime());
    }
}
