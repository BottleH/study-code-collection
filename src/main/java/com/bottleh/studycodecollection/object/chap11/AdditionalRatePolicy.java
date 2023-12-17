package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AdditionalRatePolicy implements RatePolicy {

    private final RatePolicy next;

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    protected abstract Money afterCalculated(Money fee);
}
