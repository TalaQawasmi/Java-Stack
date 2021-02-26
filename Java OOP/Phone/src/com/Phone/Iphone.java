package com.Phone;

public class Iphone extends Phone implements Ringable{
    public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "iphone " + getVersionNumber() + "says " + getRingTone();
    }
    @Override
    public String unlock() {
        String Unlock = "unlock via facial recognition";
        return Unlock;
    }
    @Override
    public void displayInfo() {
        System.out.println("iphone " + getVersionNumber() + "says " + getCarrier());
    }

}
