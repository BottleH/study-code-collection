package com.bottleh.studycodecollection.object.chap4;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 할인 조건 class
 */
@Setter
@Getter
public class DiscountCondition {

    /**
     * 할인 조건 타입
     */
    private DiscountConditionType type;

    /**
     * 상영 순번
     */
    private int sequence;

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

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                !this.startTime.isAfter(time) &&
                !this.endTime.isBefore(time);
    }

    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }
}
