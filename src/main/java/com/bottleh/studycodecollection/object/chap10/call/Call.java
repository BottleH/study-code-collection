package com.bottleh.studycodecollection.object.chap10.call;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class Call {

    @Getter
    private final LocalDateTime from;

    private final LocalDateTime to;

    public Duration getDuration() {
        return Duration.between(from, to);
    }
}
