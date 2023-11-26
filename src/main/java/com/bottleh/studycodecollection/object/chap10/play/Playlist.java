package com.bottleh.studycodecollection.object.chap10.play;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Playlist {

    private final List<Song> tracks = new ArrayList<>();

    private final Map<String, String> singers = new HashMap<>();

    public void append(Song song) {
        getTracks().add(song);
        singers.put(song.getSinger(), song.getTitle());
    }
}
