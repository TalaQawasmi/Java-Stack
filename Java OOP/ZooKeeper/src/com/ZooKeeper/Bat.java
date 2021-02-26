package com.ZooKeeper;

public class Bat extends Mammal{
    public Bat(){
        setEnergyLevel(300);
    }
    public void fly(){
        System.out.println("weeeeeeeeeeeeeeew");
        setEnergyLevel(getEnergyLevel() -50);
    }
    public void eatHumans(){
        System.out.println("yummmyyyy");
        setEnergyLevel(getEnergyLevel() + 25);
    }
    public void attackTown(){
        System.out.println("boom boom");
        setEnergyLevel(getEnergyLevel() -100);
    }
}
