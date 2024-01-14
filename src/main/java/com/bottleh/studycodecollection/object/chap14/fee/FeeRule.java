package com.bottleh.studycodecollection.object.chap14.fee;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FeeRule {

    private final FeeCondition feeCondition;

    private final FeePerDuration feePerDuration;

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(feePerDuration::calculate)
                .reduce(Money.ZERO, Money::plus);
    }
}
