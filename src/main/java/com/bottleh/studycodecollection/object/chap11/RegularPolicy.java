package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap10.call.Call;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

@RequiredArgsConstructor
public class RegularPolicy extends BasicRatePolicy {

    private final Money amount;
    private final Duration seconds;

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
