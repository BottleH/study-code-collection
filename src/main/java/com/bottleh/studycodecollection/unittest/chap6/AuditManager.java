package com.bottleh.studycodecollection.unittest.chap6;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class AuditManager {

    private final int maxEntriesPerFile;

    public FileUpdate addRecord(FileContent[] files, String visitorName, LocalDateTime timeOfVisit) {
        Arrays.sort(files);
        String newRecord = visitorName + ";" + timeOfVisit;

        if (files.length == 0) {
            return new FileUpdate("audit_1.txt", newRecord);
        }

        int currentFileIndex = files.length - 1;
        FileContent currentFile = files[currentFileIndex];
        List<String> lines = Arrays.asList(currentFile.lines());

        if (lines.size() < maxEntriesPerFile) {
            lines.add(newRecord);
            return new FileUpdate(currentFile.fileName(), String.join("\r\n", lines));
        }

        return new FileUpdate("audit_" + currentFileIndex + 1 + ".txt", newRecord);
    }
}
