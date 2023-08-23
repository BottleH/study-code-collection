package com.bottleh.studycodecollection.object.chap1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Audience {

    private Bag bag;

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
