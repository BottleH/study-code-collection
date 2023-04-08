package com.bottleh.studycodecollection.unittest.chap6;

import lombok.Getter;

@Getter
public record FileUpdate(String fileName, String newContent) {

}
