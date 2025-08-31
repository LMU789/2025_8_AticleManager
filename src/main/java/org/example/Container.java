package org.example;

import java.util.Scanner;

public class Container {

    private static Scanner scanner;

    public static void init(){
        scanner = new Scanner(System.in);
    }

    public static void scannerClose() {
        scanner.close();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
