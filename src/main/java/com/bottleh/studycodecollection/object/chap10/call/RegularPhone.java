package com.bottleh.studycodecollection.object.chap10.call;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.Getter;

import java.time.Duration;

@Getter
public class RegularPhone extends Phone {

    private final Money amount;

    private final Duration seconds;

    public RegularPhone(double taxRate, Money amount, Duration seconds) {
        super(taxRate);
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times((double) call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
