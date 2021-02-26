package com.Pokemon;

public abstract class AbstractPokemon {
    public abstract Pokemon createPokemon(String name, int health, String type);
    public abstract String pokemonInfo(Pokemon pokemon);
    public abstract void listPokemon();

}
