package com.mgareev.filework;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mark Gareev
 * Class for searching files in directory and all subdirectories;
 */

public class FileFinder {
    private int equalnamecounter;
    private TreeMap<String, Path> textfiles = new TreeMap<>();
    private MyFileVisitor visitor = new MyFileVisitor();

    public void findFiles(Path startpath) throws IOException {
        Files.walkFileTree(startpath, visitor);
    }

    public TreeMap<String, Path> getTextfiles() {
        for (Map.Entry<String,Path>item :textfiles.entrySet()) {
            System.out.println(item + " : is a textfile map item.");
        }
        return textfiles;
    }


    /**
     * Nested class to define behaviour in directory.
     */
    class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override

        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
            StringBuilder filename = new StringBuilder(file.getFileName().toString());
            System.out.println("Filename : "+ file.getFileName());
            if ((file.getFileName().toString().charAt(0) != '.')&&!(attr.isDirectory())){
                System.out.println("I work with it");
                if (!textfiles.containsKey(filename.toString()))
                    textfiles.put(filename.toString(), file);
                else {
                    filename.append(equalnamecounter);
                    textfiles.put(filename.toString(), file);
                    equalnamecounter++;
                }
                return FileVisitResult.CONTINUE;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
