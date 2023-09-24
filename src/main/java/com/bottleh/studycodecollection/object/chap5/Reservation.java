package com.bottleh.studycodecollection.object.chap5;

import com.bottleh.studycodecollection.object.chap2.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 예매 정보 Class
 */
@Setter
@Getter
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
