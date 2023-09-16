package com.bottleh.studycodecollection.object.chap4;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 상영 Class
 */
@Setter
@Getter
@AllArgsConstructor
public class Screening {

    /**
     * 영화
     */
    private Movie movie;

    /**
     * 순번
     */
    private int sequence;

    /**
     * 상영 시작 시간
     */
    private LocalDateTime whenScreened;

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
            }
            case PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount);
                }
            }
            case NONE_DISCOUNT -> {
                return movie.calculateNoneDiscountedFee().times(audienceCount);
            }
        }
        return movie.calculateNoneDiscountedFee().times(audienceCount);
    }
}
