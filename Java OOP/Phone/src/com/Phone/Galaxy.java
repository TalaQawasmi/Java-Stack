package com.Phone;

public class Galaxy extends Phone implements Ringable{
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "galaxy " + getVersionNumber() + "says " + getRingTone();
    }
    @Override
    public String unlock() {
        String Unlock = "unlock via fingerprint";
        return Unlock;
    }
    @Override
    public void displayInfo() {
        System.out.println("galaxy " + getVersionNumber() + "says " + getCarrier());
    }
}
