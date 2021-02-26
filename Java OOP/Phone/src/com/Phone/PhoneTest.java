package com.Phone;

public class PhoneTest {
    public static void main(String[] args) {
        Galaxy s9 = new Galaxy("S9", 99, "Jawwal","Tararararara");
        Iphone promax11 = new Iphone("promax11",100,"Wataniye","whohhohoh");

        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());

        promax11.displayInfo();
        System.out.println(promax11.ring());
        System.out.println(promax11.unlock());

    }
}
