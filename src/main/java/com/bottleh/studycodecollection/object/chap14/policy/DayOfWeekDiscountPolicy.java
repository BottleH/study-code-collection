package com.bottleh.studycodecollection.object.chap14.policy;

import com.bottleh.studycodecollection.object.chap14.domain.Call;
import com.bottleh.studycodecollection.object.chap14.domain.DateTimeInterval;
import com.bottleh.studycodecollection.object.chap14.fee.FeeRule;
import com.bottleh.studycodecollection.object.chap2.Money;

import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {

    private final List<DayOfWeekDiscountRule> rules = new ArrayList<>();

    protected DayOfWeekDiscountPolicy(List<FeeRule> feeRules) {
        super(feeRules);
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money result = Money.ZERO;

        for (DateTimeInterval interval : call.getInterval().splitByDay()) {
            for (DayOfWeekDiscountRule rule : rules) {
                result.plus(rule.calculate(interval));
            }
        }

        return result;
    }
}
