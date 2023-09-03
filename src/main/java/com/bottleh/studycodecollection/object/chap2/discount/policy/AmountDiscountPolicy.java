package com.bottleh.studycodecollection.object.chap2.discount.policy;

import com.bottleh.studycodecollection.object.chap2.Money;
import com.bottleh.studycodecollection.object.chap2.Screening;
import com.bottleh.studycodecollection.object.chap2.discount.condition.DiscountCondition;

/**
 * 금액 할인 정책 class
 */
public class AmountDiscountPolicy extends DiscountPolicy {

    /**
     * 할인 요금
     */
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
