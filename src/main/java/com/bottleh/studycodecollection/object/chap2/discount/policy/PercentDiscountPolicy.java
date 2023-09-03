package com.bottleh.studycodecollection.object.chap2.discount.policy;

import com.bottleh.studycodecollection.object.chap2.Money;
import com.bottleh.studycodecollection.object.chap2.Screening;
import com.bottleh.studycodecollection.object.chap2.discount.condition.DiscountCondition;

/**
 * 비율 할인 정책 class
 */
public class PercentDiscountPolicy extends DiscountPolicy {

    /**
     * 할인 비율
     */
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
