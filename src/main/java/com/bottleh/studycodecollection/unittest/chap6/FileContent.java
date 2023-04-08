package com.bottleh.studycodecollection.unittest.chap6;

import lombok.Getter;

@Getter
public record FileContent(String fileName, String[] lines) {

}
