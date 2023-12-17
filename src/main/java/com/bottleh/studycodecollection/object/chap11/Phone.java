package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap10.call.Call;
import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Phone {

    private final RatePolicy ratePolicy;

    @Getter
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
