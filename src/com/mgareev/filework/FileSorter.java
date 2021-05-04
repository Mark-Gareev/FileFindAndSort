package com.mgareev.filework;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Mark Gareev
 * Class for sorting and concatenate founded files. Use FileFinder to searching.
 */
public class FileSorter {

    Path startpath;
    ArrayList<Path>filetreefiles = new ArrayList<>();
    FileFinder finder = new FileFinder(startpath);

    public FileSorter(String path)
    {
        this.startpath = Paths.get(path);
    }


}
