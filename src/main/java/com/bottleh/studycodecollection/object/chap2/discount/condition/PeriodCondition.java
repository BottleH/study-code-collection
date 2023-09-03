package com.bottleh.studycodecollection.object.chap2.discount.condition;

import com.bottleh.studycodecollection.object.chap2.Screening;
import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@AllArgsConstructor
public class PeriodCondition implements DiscountCondition {

    /**
     * 조건에 사용할 요일
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

    /**
     * 할인 여부 판단 Method
     * <pre>
     *     - 상영 요일이 같고, 상영 시작 시간이 startTime과 endTime 사이에 있을 경우 할인
     * </pre>
     * @param screening 상영
     * @return 할인 여부
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                !startTime.isAfter(screening.getStartTime().toLocalTime()) &&
                !endTime.isBefore(screening.getStartTime().toLocalTime());
    }
}
