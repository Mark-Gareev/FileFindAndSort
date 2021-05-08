package com.mgareev.main;

import com.mgareev.filework.FileConcater;
import com.mgareev.filework.FileConcater;
import com.mgareev.filework.FileFinder;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            System.out.println("Put start path here:");
            Scanner scanner = new Scanner(System.in);
            Path startpath = Paths.get(scanner.nextLine());
            FileFinder finder = new FileFinder();
            finder.findFiles(startpath);
            FileConcater concater = new FileConcater(finder.getTextfiles());
            System.out.println("Put result path here:");
            Path resultpath = Paths.get(scanner.nextLine()+ "/resultFile.txt");
            concater.sortAndConcat(resultpath);
            scanner.close();
            System.out.println("Done.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
}
