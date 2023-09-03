package com.bottleh.studycodecollection.object.chap2.discount.policy;

import com.bottleh.studycodecollection.object.chap2.Money;
import com.bottleh.studycodecollection.object.chap2.Screening;

/**
 * 0원 할인 정책 class
 */
public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
