package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap10.call.Call;
import com.bottleh.studycodecollection.object.chap2.Money;

public abstract class BasicRatePolicy implements RatePolicy{

    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
