package com.ObjectMaster;

public class Wizard extends Human{
    public Wizard(){
        setHealth(50);
        setIntelligence(8);
        getStealth();
        getStrength();
    }

    public void attack(Human h){
        h.setHealth(this.getHealth()-this.getStrength());
    }
    public void heal(Human h){
        h.setHealth(this.getHealth()+this.getIntelligence());
    }
    public void fireball(Human h){
        h.setHealth(this.getHealth()-(this.getIntelligence()*3));
    }

}
