package com.bottleh.studycodecollection.object.chap13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Rectangle {

    private final int x;

    private final int y;

    @Getter
    @Setter
    private int width;

    @Getter
    @Setter
    private int height;

    public int getArea() {
        return width * height;
    }
}
