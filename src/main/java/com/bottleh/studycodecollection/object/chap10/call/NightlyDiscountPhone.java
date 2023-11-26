package com.bottleh.studycodecollection.object.chap10.call;

import com.bottleh.studycodecollection.object.chap2.Money;

import java.time.Duration;

public class NightlyDiscountPhone extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private final Money nightlyAmount;

    private final Money regularAmount;

    private final Duration seconds;

    public NightlyDiscountPhone(double taxRate, Money nightlyAmount, Money regularAmount, Duration seconds) {
        super(taxRate);
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
        }
        return regularAmount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
