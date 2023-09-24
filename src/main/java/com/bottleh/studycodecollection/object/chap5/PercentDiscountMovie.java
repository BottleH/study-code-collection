package com.bottleh.studycodecollection.object.chap5;

import com.bottleh.studycodecollection.object.chap2.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {

    private final double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent, DiscountCondition... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
