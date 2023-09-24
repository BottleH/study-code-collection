package com.bottleh.studycodecollection.object.chap5;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 영화 Class
 */
public abstract class Movie {

    /**
     * 제목
     */
    private final String title;

    /**
     * 상영 시간
     */
    private final Duration runningTime;

    /**
     * 기본 요금
     */
    @Getter(AccessLevel.PROTECTED)
    private final Money fee;

    /**
     * 할인 조건 목록
     */
    private final List<DiscountCondition> discountConditions;

    protected Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected abstract Money calculateDiscountAmount();
}
