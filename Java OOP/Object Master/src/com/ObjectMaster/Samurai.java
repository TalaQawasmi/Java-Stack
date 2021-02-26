package com.ObjectMaster;

public class Samurai extends Human{
    static int count =0;
    public Samurai(){
        int count =0;
        setHealth(200);
        getIntelligence();
        getStealth();
        getStrength();
        count += 1;
    }
    public void attack(Human B){
        setHealth(this.getHealth()-this.getStrength());
    }
    public void deathBlow(Human H){
        H.setHealth(0);
        this.setHealth(this.getHealth()/2);
    }
    public void meditate(){
        this.setHealth((this.getHealth()/2) + this.getHealth());
    }
    public int howMany(int count){
        return count;
    }
}