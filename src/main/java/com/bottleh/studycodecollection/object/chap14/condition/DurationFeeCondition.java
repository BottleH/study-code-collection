package com.bottleh.studycodecollection.object.chap14.condition;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap14.domain.DateTimeInterval;
import com.bottleh.studycodecollection.object.chap14.fee.FeeCondition;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class DurationFeeCondition implements FeeCondition {

    private final Duration from;
    private final Duration to;

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        if (call.getInterval().duration().compareTo(from) < 0) {
            return Collections.emptyList();
        }

        return List.of(DateTimeInterval.of(
                call.getInterval().getFrom().plus(from),
                call.getInterval().duration().compareTo(to) > 0 ?
                        call.getInterval().getFrom().plus(to) :
                        call.getInterval().getTo()));
    }
}
