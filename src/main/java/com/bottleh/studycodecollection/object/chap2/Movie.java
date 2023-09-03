package com.bottleh.studycodecollection.object.chap2;

import com.bottleh.studycodecollection.object.chap2.discount.policy.DiscountPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

/**
 * 영화 Class
 */
@AllArgsConstructor
public class Movie {

    /**
     * 제목
     */
    private String title;

    /**
     * 상영시간
     */
    private Duration runningTime;

    /**
     * 기본요금
     */
    @Getter
    private Money fee;

    /**
     * 할인 정책
     */
    private DiscountPolicy discountPolicy;

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
