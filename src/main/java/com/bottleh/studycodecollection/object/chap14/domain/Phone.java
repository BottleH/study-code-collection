package com.bottleh.studycodecollection.object.chap14.domain;

import com.bottleh.studycodecollection.object.chap14.policy.RatePolicy;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Phone {

    private final RatePolicy ratePolicy;

    @Getter
    private final List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
