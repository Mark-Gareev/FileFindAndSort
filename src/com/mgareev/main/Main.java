package com.mgareev.main;

import com.mgareev.filework.FileConcater;
import com.mgareev.filework.FileFinder;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// example of using my filework package
        try {
            System.out.println("Put start path here:");
            Scanner scanner = new Scanner(System.in);
            Path startpath = Paths.get(scanner.nextLine());
            System.out.println("Put result path here:");
            Path resultpath = Paths.get(scanner.nextLine()+ "/resultFile.txt");
            FileFinder fileFinder = new FileFinder();
            fileFinder.findFiles(startpath);
            FileConcater fileConcater = new FileConcater(fileFinder.getTextfiles());
            fileConcater.sortAndConcat(resultpath);
            scanner.close();
            System.out.println("Done.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
}
