package com.bottleh.studycodecollection.object.chap14.policy;

import com.bottleh.studycodecollection.object.chap14.domain.Phone;
import com.bottleh.studycodecollection.object.chap2.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
