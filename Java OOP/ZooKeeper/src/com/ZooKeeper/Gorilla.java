package com.ZooKeeper;

public class Gorilla extends Mammal {
    public Gorilla(){
        getEnergyLevel();
    }

    public void throwSomething(){
        System.out.println("The gorilla is throwing something");
        setEnergyLevel(getEnergyLevel() -5);
    }
    public void eatBananas(){
        System.out.println("The gorilla is happy and full now");
        setEnergyLevel(getEnergyLevel() +10);
    }
    public void climb(){
        System.out.println("The gorilla has climbed the tree");
        setEnergyLevel(getEnergyLevel() -10);
    }

}
