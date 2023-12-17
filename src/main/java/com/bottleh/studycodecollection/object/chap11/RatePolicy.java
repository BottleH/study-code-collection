package com.bottleh.studycodecollection.object.chap11;

import com.bottleh.studycodecollection.object.chap2.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
