package com.bottleh.studycodecollection.object.chap2;

import lombok.Getter;

public class Movie {

    @Getter
    private Money fee;

    public Money calculateMovieFee(Screening screening) {
        return fee;
    }
}
