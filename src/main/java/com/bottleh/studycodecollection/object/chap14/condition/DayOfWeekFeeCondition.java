package com.bottleh.studycodecollection.object.chap14.condition;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap14.domain.DateTimeInterval;
import com.bottleh.studycodecollection.object.chap14.fee.FeeCondition;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class DayOfWeekFeeCondition implements FeeCondition {

    private final List<DayOfWeek> dayOfWeeks;

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval()
                .splitByDay()
                .stream()
                .filter(each -> dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
                .collect(toList());
    }
}
