package com.bottleh.studycodecollection.object.chap2.discount.policy;

import com.bottleh.studycodecollection.object.chap2.Money;
import com.bottleh.studycodecollection.object.chap2.Screening;
import com.bottleh.studycodecollection.object.chap2.discount.condition.DiscountCondition;

import java.util.Arrays;
import java.util.List;

/**
 * 할인 정책 class
 */
public abstract class DiscountPolicy {
    private final List<DiscountCondition> conditions;

    protected DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }
    protected abstract Money getDiscountAmount(Screening screening);
}
