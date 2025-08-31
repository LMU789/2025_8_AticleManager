package org.example;

import org.example.app.App;
import org.example.util.Container;

public class Main {
    public static void main(String[] args) {

        Container.init();

        new App().run();

        Container.scannerClose();

    }
}