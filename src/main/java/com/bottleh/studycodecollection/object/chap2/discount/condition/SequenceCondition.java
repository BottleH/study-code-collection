package com.bottleh.studycodecollection.object.chap2.discount.condition;

import com.bottleh.studycodecollection.object.chap2.Screening;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SequenceCondition implements DiscountCondition {

    /**
     * 순번
     */
    private int sequence;

    /**
     * 할인 여부 판단 Method
     * <pre>
     *     - 상영 순번과 일치할 경우 할인 가능
     * </pre>
     *
     * @param screening 상영
     * @return 할인 여부
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
