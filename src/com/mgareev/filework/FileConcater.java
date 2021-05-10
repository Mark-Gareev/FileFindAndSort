package com.mgareev.filework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * @author Mark Gareev
 * Class for concatenate founded files.
 */
public class FileConcater {

    private Map<String, Path> fileMap;

    public void concatenate(Path resultpath) throws IOException {
        List<String> lines;
        Files.createFile(resultpath);
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, Path> file : fileMap.entrySet()) {
            lines = Files.readAllLines(file.getValue());

            for (String item : lines) {
                buffer.append(item);
            }
            lines.clear();
        }
        Files.writeString(resultpath, buffer.toString());
    }

    public FileConcater(Map<String, Path> fileMap) {
        this.fileMap = fileMap;
    }


}
