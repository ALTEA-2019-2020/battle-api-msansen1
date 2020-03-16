package com.miage.altea.battle_api.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BattlePokemon {

    //private int id;
    private PokemonType type;
    private int maxhp;
    private int attack;
    private int defense;
    private int speed;
    private int level;
    private int hp;
    private Boolean ko;
    private Boolean alive;

    public BattlePokemon(PokemonType pokemon) {
        this.type = pokemon;
    }
}
