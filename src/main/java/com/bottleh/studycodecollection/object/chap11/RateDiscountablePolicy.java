package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap2.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

    private final Money discountAmount;

    public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
        super(next);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
