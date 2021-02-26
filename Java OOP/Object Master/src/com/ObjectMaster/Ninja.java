package com.ObjectMaster;

public class Ninja extends Human{
    public Ninja(){
        getHealth();
        getIntelligence();
        setStealth(10);
        getStrength();
    }
    public void attack(Human R){
        setHealth(this.getHealth()-this.getStrength());
    }
    public void steal(Human O){
        O.setHealth(this.getHealth()-this.getStealth());
        setHealth(this.getHealth()+this.getStealth());
        System.out.println(getHealth());
    }
    public void runAway(){
        this.setHealth(this.getHealth()-10);
    }

}
