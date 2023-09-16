package com.bottleh.studycodecollection.object.chap4;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 데이터 중심 설계 영화 Class
 */
public class Movie {

    /**
     * 제목
     */
    private String title;

    /**
     * 상영 시간
     */
    private Duration runningTime;

    /**
     * 기본 요금
     */
    @Getter
    @Setter
    private Money fee;

    /**
     * 할인 조건 목록
     */
    @Getter
    @Setter
    private List<DiscountCondition> discountConditions;

    /**
     * 할인 정책의 종류를 결정하는 변수
     */
    @Getter
    @Setter
    private MovieType movieType;

    /**
     * 할인 금액
     */
    @Getter
    @Setter
    private Money discountAmount;

    /**
     * 할인 비율
     */
    @Getter
    @Setter
    private double discountPercent;

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }
        return false;
    }
}
