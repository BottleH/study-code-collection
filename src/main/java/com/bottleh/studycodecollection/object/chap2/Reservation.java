package com.bottleh.studycodecollection.object.chap2;

import lombok.AllArgsConstructor;

/**
 * 예매 정보 Class
 */
@AllArgsConstructor
public class Reservation {

    /**
     * 고객
     */
    private Customer customer;

    /**
     * 상영
     */
    private Screening screening;

    /**
     * 예매 요금
     */
    private Money fee;

    /**
     * 인원 수
     */
    private int audienceCount;
}
