package com.Pokemon;

import java.util.ArrayList;
public class Pokedex extends AbstractPokemon{
    ArrayList<Pokemon> List;
    ArrayList<String>L;

    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon pokimon1= new Pokemon(name, health, type);
        L=new ArrayList<String>();
        List=new ArrayList<Pokemon>();
        L.add(pokimon1.getName());
        List.add(pokimon1);
        return pokimon1;
    }

    @Override
    public String pokemonInfo(Pokemon pokemon) {
        String first= "name:"+pokemon.getName()+"health:"+ pokemon.getHealth()+"type:"+pokemon.getType();
        return first;
    }

    @Override
    public ArrayList<String> listPokemon() {
        return L;
    }

}
