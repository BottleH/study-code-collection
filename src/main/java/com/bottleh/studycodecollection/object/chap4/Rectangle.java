package com.bottleh.studycodecollection.object.chap4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public void enlarge(int multiple) {
        right *= multiple;
        bottom *= multiple;
    }
}
