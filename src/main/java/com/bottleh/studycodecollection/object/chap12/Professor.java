package com.bottleh.studycodecollection.object.chap12;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Professor {

    private final String name;

    private final Lecture lecture;

    public String compileStatistics() {
        return String.format("[%s] %s - Avg: %.1f", name, lecture.evaluate(), lecture.average());
    }
}
