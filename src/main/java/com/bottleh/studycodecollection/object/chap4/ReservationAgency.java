package com.bottleh.studycodecollection.object.chap4;

import com.bottleh.studycodecollection.object.chap2.Money;

/**
 * 영화 예매 절차 구현 Class
 */
public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
