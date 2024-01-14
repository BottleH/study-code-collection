package com.bottleh.studycodecollection.object.chap14.policy;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.RequiredArgsConstructor;

import java.time.Duration;

@RequiredArgsConstructor
public class FixedFeePolicy extends BasicRatePolicy {

    private final Money amount;
    private final Duration seconds;

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
