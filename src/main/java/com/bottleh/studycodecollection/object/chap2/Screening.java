package com.bottleh.studycodecollection.object.chap2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 상영 Class
 */
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
    @Getter
    private LocalDateTime startTime;

    /**
     * 순번 일치 여부 검사
     */
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    /**
     * 기본 요금 반환
     */
    public Money getMovieFee() {
        return movie.getFee();
    }

    /**
     * 영화 예매 기능
     *
     * @param customer      예매자 정보
     * @param audienceCount 인원수
     * @return 예매 정보
     */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    /**
     * 전체 예매 요금 계산
     *
     * @param audienceCount 인원수
     * @return 전체 예매 요금
     */
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
