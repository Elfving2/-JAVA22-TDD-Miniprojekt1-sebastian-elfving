package main;

import triangle.Triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2,3,2);
        // triangle = new Triangle(new String[]{"1","2","3"});
        triangle.getCurrent_type();
        triangle.getUserInput();
        triangle.getCurrent_type();
    }
}