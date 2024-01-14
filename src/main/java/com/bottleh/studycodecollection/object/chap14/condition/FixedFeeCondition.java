package com.bottleh.studycodecollection.object.chap14.condition;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap14.domain.DateTimeInterval;
import com.bottleh.studycodecollection.object.chap14.fee.FeeCondition;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class FixedFeeCondition implements FeeCondition {

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return Collections.singletonList(call.getInterval());
    }
}
