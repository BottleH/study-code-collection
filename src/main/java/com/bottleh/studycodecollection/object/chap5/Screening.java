package com.bottleh.studycodecollection.object.chap5;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 상영 Class
 */
public class Screening {

    /**
     * 영화
     */
    private Movie movie;

    /**
     * 순번
     */
    @Getter
    private int sequence;

    /**
     * 상영 시작 시간
     */
    @Getter
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
