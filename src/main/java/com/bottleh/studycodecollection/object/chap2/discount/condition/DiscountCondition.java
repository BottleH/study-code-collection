package com.bottleh.studycodecollection.object.chap2.discount.condition;

import com.bottleh.studycodecollection.object.chap2.Screening;

/**
 * 할인 조건 interface
 */
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
