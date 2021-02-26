package com;

public class CalclatorTest {
    public static void main(String[] args) {
        Calculator sample1 = new Calculator(15.5,"+",8.2);
        Calculator sample2 = new Calculator(82.0,"-",89.0);
        sample1.performOperation();
        sample2.performOperation();
        sample1.getResults();
        sample2.getResults();
    }
}
