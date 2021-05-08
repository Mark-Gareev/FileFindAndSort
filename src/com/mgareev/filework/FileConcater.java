package com.mgareev.filework;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Mark Gareev
 * Class for concatenate founded files. Use FileFinder to searching.
 */
public class FileConcater {

    private Map<String, Path> filetree;
    private FileFinder finder = new FileFinder();

    public void sortAndConcat(Path resultpath) throws IOException {
        List<String> lines;
        Files.createFile(resultpath);
        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String,Path> file: filetree.entrySet()) {
            lines = Files.readAllLines(file.getValue());

            for (String item : lines) {
                buffer.append(item);
            }
            lines.clear();
        }
        Files.writeString(resultpath,buffer.toString());
    }

    public FileConcater(Map<String, Path> filetree) {
        this.filetree = filetree;
    }
    //public void fileSort(HashMap<String,Path>filetreefiles){


}
