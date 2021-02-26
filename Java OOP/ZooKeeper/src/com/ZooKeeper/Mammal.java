package com.ZooKeeper;

public class Mammal {
    private int energyLevel;
    public Mammal(){
        setEnergyLevel(100);
    }
    public void displayEnergy(){
        System.out.println(energyLevel);
    }
    public void setEnergyLevel(int energy) {
        this.energyLevel = energy;
    }
    public int getEnergyLevel() {
        return energyLevel;
    }
}

