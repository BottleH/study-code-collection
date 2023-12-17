package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap10.call.Call;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

@RequiredArgsConstructor
public class NightlyDiscountPolicy extends BasicRatePolicy {

    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightlyAmount;
    private final Money regularAmount;
    private final Duration seconds;

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
        }
        return regularAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
