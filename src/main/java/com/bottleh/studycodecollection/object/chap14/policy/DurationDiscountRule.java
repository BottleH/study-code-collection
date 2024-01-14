package com.bottleh.studycodecollection.object.chap14.policy;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap2.Money;

import java.time.Duration;

public class DurationDiscountRule extends FixedFeePolicy {

    private final Duration from;
    private final Duration to;

    public DurationDiscountRule(Money amount, Duration seconds, Duration from, Duration to) {
        super(amount, seconds);
        this.from = from;
        this.to = to;
    }

    public Money calculate(Call call) {
        if (call.getDuration().compareTo(to) > 0) {
            return Money.ZERO;
        }

        if (call.getDuration().compareTo(from) < 0) {
            return Money.ZERO;
        }

        return super.calculateCallFee(new Call(call.getFrom().plus(from),
                call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo()));
    }
}
