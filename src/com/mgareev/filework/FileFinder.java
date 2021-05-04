package com.mgareev.filework;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

/**
 * @author Mark Gareev
 * Class for searching files in directory and all subdirectories;
 */

public class FileFinder {
    public FileFinder(Path path)
    {
        this.startpath = path;
    }
    Path startpath;

    /**
     * Nested class to define behaviour in directory.
     */
    class MyFileVisitor extends SimpleFileVisitor{

    }
}
