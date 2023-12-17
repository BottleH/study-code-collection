package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap2.Money;

public class TaxablePolicy extends AdditionalRatePolicy {

    private final double taxRatio;

    public TaxablePolicy(RatePolicy next, double taxRatio) {
        super(next);
        this.taxRatio = taxRatio;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}
