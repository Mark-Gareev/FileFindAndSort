package com.mgareev.main;

import com.mgareev.filework.FileSorter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Put path here:");
        Scanner scanner = new Scanner(System.in);
        String startpath = scanner.nextLine();
        FileSorter sorter = new FileSorter(startpath);
        
    }
}
