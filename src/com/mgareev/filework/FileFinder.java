package com.mgareev.filework;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeMap;

/**
 * @author Mark Gareev
 * Class for searching files in directory and all subdirectories;
 */

public class FileFinder {

    private int equalnamecounter;//equalnamecounter used to make difference btw files witch have equal names.
    private TreeMap<String, Path> textfiles = new TreeMap<>();
    private MyFileVisitor visitor = new MyFileVisitor();

    public void findFiles(Path startpath) throws IOException {
        Files.walkFileTree(startpath, visitor);
    }

    public TreeMap<String, Path> getTextfiles() {
        return textfiles;
    }


    /**
     * Nested class to define behaviour in directory.
     */
    class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override

        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            String filename = file.getFileName().toString();
            if ((filename.charAt(0) != '.') && !(attr.isDirectory())) {
                if (!textfiles.containsKey(filename)) {
                    textfiles.put(filename, file);
                } else {
                    filename += equalnamecounter;
                    textfiles.put(filename, file);
                    equalnamecounter++;
                }
                return FileVisitResult.CONTINUE;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
