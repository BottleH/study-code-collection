package com.bottleh.studycodecollection.unittest.chap6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class Persister {

    public FileContent[] readDirectory(String directoryName) {
        return Arrays.stream(Objects.requireNonNull(new File(directoryName).listFiles()))
                .map(file -> {
                    try {
                        return new FileContent(file.getName(), Files.readAllLines(file.toPath()).toArray(String[]::new));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toArray(FileContent[]::new);
    }

    public void applyUpdate(String directoryName, FileUpdate update) {
        String filePath = Paths.get(directoryName, update.fileName()).toString();
        try {
            Files.write(Paths.get(filePath), update.newContent().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
