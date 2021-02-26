package com.Pokemon;

public class Pokemon {
    private String name;
    private int health;
    private String type;
    static int count = 0;

    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        count += 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }
    void attackPokemon(Pokemon pokemon){
        pokemon.setHealth(pokemon.getHealth()-10);
    }

}
