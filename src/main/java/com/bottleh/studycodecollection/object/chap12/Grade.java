package com.bottleh.studycodecollection.object.chap12;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Grade {

    /**
     * 등급 이름
     */
    @Getter
    private final String name;

    /**
     * 최대 성적, 최소 성적
     */
    private final int upper, lower;

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean include(int score) {
        return score >= lower && score <= upper;
    }
}
