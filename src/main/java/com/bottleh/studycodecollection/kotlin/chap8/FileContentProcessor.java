package com.bottleh.studycodecollection.kotlin.chap8;

import java.io.File;
import java.util.List;

public interface FileContentProcessor {
    void processContents(File path, byte[] binaryContents, List<String> textContents);
}
